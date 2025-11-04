using namespace std;
#include <iostream>
#include <stdexcept>
#include <vector>
#include <cstdlib>
#include <ctime>

enum Color { RED, GREEN, BLUE, YELLOW};

class Cell{
    private:
        Color color;
    public:
        Cell(Color c): color(c){}

        Color getColor() const {return color;}
        void setColor(Color c) { color = c;}

        char getColorL() const {
            switch(color){
                case RED: return 'R';
                case GREEN: return 'G';
                case BLUE: return 'B';
                case YELLOW: return 'Y';
            }
            return ' '; 
        }
};


class BoombCell : public Cell{
    public:
        BoombCell(Color c): Cell(c) {};
    
        char getColorL() const{ return 'B';}
};

class ArrowCell: public Cell{
    public:
        ArrowCell(Color c): Cell(c){};

        char getColorL() const{return 'A';}
};

class Game{
    private:
        int width;
        int height;
        vector<vector<Cell>> board;

    public:
        Color randomColor(){
            int r = rand() % 3;
            return static_cast<Color>(r);
        }

        int fillBoard(){
            for(int i = 0; i< height; i++){
                for(int j = 0; j < width; j++){
                    int rb = rand() % 14;
                    if(rb <= 9){
                        board[i][j] = ArrowCell(randomColor());
                    } else if(rb> 9){
                        board[i][j] = BoombCell(randomColor());
                    } else{
                        board[i][j] = Cell(randomColor());
                    }
                }
            }
        }

        void printBoard(){
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    cout << board[i][j].getColorL() << " ";
                }
                cout << endl;
            }
        }
};

// void BombCell onSwapped(Game& game, int x, int y) {
//     for (int dy=-1; dy<=1; dy++) {
//         for (int dx=-1; dx<=1; dx++) {
//             game.clearCell(x+dx, y+dy);
//         }
//     }
// }


int main(){
    srand(time(nullptr));
    Game game;
    game.fillBoard();
    game.printBoard();
    return 0;
}