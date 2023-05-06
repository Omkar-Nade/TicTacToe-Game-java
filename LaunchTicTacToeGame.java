package com.kunal;

import com.sun.source.tree.BreakTree;

class TicTacToe {
    static char[][] board;

    // 3X3 board is created and at same initialization also occur
    public TicTacToe(){
        board = new char[3][3];
        initBord();
    }

    // initialization board with empty character
    void initBord(){
        for(int i=0; i< board.length; i++){
            for (int j=0; j< board[i].length;j++){
               board[i][j]= ' ';
            }
        }
    }

    // DisplayBoard
    void displayBoard(){
        System.out.println("-------------");
        for(int i=0; i< board.length; i++){
            System.out.print("| ");
            for (int j=0; j< board[i].length;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // place mark with 'x' and 'o' character
    void placeMark(int row, int col, char mark){
        if (row>=0 && row<=2 && col>=0 && col<=2 ){
            board[row][col] = mark;
        } else {
            System.out.println("invalid position");
        }
    }

    // check column win condition
    boolean checkColWin(){
        for (int j=0; j<2;j++){
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]){
               return true;
            }
        }
        return false;
    }

    // check row win condition
    boolean checkRowWin(){
        for (int i=0; i<2;i++){
            if( board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
               return true;
            }
        }
        return false;
    }

    // check diagonal win condition
    boolean checkDiagWin(){
      if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
              board[0][2] == ' ' &&  board[0][2] == board[1][1] && board[1][1] == board[2][2] )
      {
          return true;
      }
      return false;
    }

    boolean isValidMove(int row , int col){
        if(row>=0 && row<=2 && col>=0 && col<=2) {
            if (TicTacToe.board[row][col] == ' ') {
              return true;
            }
        }
        return false;
    }

}


 // main class
public class LaunchTicTacToeGame {

    // main function
    public static void main(String[] args) {
    TicTacToe t = new TicTacToe();
    t.displayBoard();
    t.placeMark(0,0,'x');
    t.placeMark(1,1,'x');
    t.placeMark(2,0,'x');
    t.placeMark(0,2,'o');
    t.placeMark(1,0,'x');
    t.placeMark(1,2,'x');
    t.placeMark(2,2,'x');
    t.displayBoard();
        System.out.println(t.checkColWin());
        System.out.println(t.checkRowWin());
        System.out.println(t.checkDiagWin());


    }
}
