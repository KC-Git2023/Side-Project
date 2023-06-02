package ticTacToe;

enum GridPosition {
    ONE(0,0), TWO(0,4), THREE(0,8),
    FOUR(2,0), FiVE(2, 4), SIX(2,8),
    SEVEN(4,0), EIGHT(4,4), NINE(4,8);
    
    private int row, col;
    
    GridPosition (int r, int c){
        row = r;
        col = c;
    }
    
    int getRow() {
        return row;
    }
    
    int getCol() {
        return col;
    }
    
}