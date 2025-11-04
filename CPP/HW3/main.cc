#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class FileInfo {
protected:
    string filename;
    size_t size;
public:
    FileInfo(const string& fname): filename(fname), size(0)
    {
        ifstream in(filename.c_str(), ios::binary | ios::ate);
        if (in) size = in.tellg();
    }
    virtual ~FileInfo() {}
    virtual void printDetails(ostream& os) const = 0;
};

class TextFileInfo : public FileInfo {
public:
    TextFileInfo(const string& fname) : FileInfo(fname) {}
    void printDetails(ostream& os) const override {
        os << "Text file: " << filename << "\n";
        os << "Size: " << size << " bytes\n";
    }
};

class ArchiveFileInfo : public FileInfo {
    string algo;
    unsigned short mode;
    size_t payloadSize;
public:
    ArchiveFileInfo(const string& fname) : FileInfo(fname), mode(0), payloadSize(0) {
        ifstream in(filename.c_str(), ios::binary);
        char buf[4];
        if (in.read(buf, 4)) {
            algo.assign(buf, 4);
        }
        if (size > 6) payloadSize = size - 6;
    }
    void printDetails(ostream& os) const override {
        os << "Archive file: " << filename << "\n";
        os << "Algo: " << algo << "\n";
        os << "Mode: " << mode << "\n";
        os << "Payload: " << payloadSize << " bytes\n";
    }
};

class ImageFileInfo : public FileInfo {
    unsigned short width;
    unsigned short height;
    unsigned char channels;
    size_t payloadSize;
public:
    ImageFileInfo(const string& fname) : FileInfo(fname), width(0), height(0), channels(0), payloadSize(0) {
        ifstream in(filename.c_str(), ios::binary);
        in.read(reinterpret_cast<char*>(&width), 2);
        in.read(reinterpret_cast<char*>(&height), 2);
        in.read(reinterpret_cast<char*>(&channels), 1);
        if (size > 5) payloadSize = size - 5;
    }
    void printDetails(ostream& os) const override {
        os << "Image file: " << filename << "\n";
        os << "Width: " << width << ", Height: " << height << "\n";
        os << "Channels: " << (int)channels << "\n";
        os << "Payload: " << payloadSize << " bytes\n";
    }
};

FileInfo* makeFileInfo(const string& fname) {
    int n = fname.size();
    if (n >= 4 && fname.substr(n - 4) == ".txt") return new TextFileInfo(fname);
    if (n >= 8 && fname.substr(n - 8) == ".archive") return new ArchiveFileInfo(fname);
    if (n >= 6 && fname.substr(n - 6) == ".image") return new ImageFileInfo(fname);
    return 0;
}

int main() {
    vector<string> files;
    files.push_back("example.txt");
    files.push_back("backup.archive");
    files.push_back("picture.image");

    for (size_t i = 0; i < files.size(); i++) {
        cout << i << ": " << files[i] << "\n";
    }

    cout << "Selec";
    size_t choice;
    cin >> choice;

    FileInfo* info = makeFileInfo(files[choice]);
    info->printDetails(cout);
    delete info;
}
