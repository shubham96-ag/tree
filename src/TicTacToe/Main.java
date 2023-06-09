package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                board[row][col] = ' ';

        char player = 'X';
        boolean gameOver = false, isFull=false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            if(isBoardFull(board)) {
                System.out.println("***********game is draw*****************");
                return;
            }
            System.out.println("Player " + player+" Enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(row>2 || col>2 || row<0 || col<0){
                System.out.println("************Please enter valid position 0,1,2**************");
                continue;
            }
            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver = haveWon(board,player);
                if(gameOver) {
                    printBoard(board);
                    System.out.println("player " + player + " has won");
                }
                else{
                    player=player=='X'?'O':'X'; //next player turn
                }
            }else {
                System.out.println("Invalid Move : player "+player+" try again");
            }

        }
    }
//Addition check added for board is full or not
    private static boolean isBoardFull(char[][] board) {
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++)
                if(board[i][j]=='X' || board[i][j]=='O')
                    count++;
        }
        if(count==9)
            return true;
        return false;
    }

    private static boolean haveWon(char[][] board, char player) {
        //check the rows
        for(int row=0; row<board.length;row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
                return true;
        }
        //check the cols
        for(int col=0; col<board.length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
                return true;
        }
        //check the diagonals
        if(board[0][0] == player && board[1][1]==player && board[2][2]==player)
            return true;
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            return true;
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++)
                System.out.print(board[row][col]+" "+"|");
            System.out.println();
        }
    }

}
