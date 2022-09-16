package com.company;

import java.util.Scanner;

public class Main {
// the tic-tac-toe game
    public static void main(String[] args) {
        System.out.println("Enter the size of the board");
        Scanner scanner = new Scanner(System.in);
        int numberOfMoves = 0;
        int boardDimension = scanner.nextInt();
        boolean end= true;
        char playerSymbol = 'X';
        char board[][] = new char[boardDimension][boardDimension];

       while (end && numberOfMoves<boardDimension * boardDimension) {

           Main.printCharts(board);

           boolean correctMovement = makeAMove(board, playerSymbol);

               if (correctMovement) {
                   numberOfMoves++;
                   boolean rowWinner = rowCheck(board, playerSymbol);
                   if (rowWinner) {
                       System.out.println("Congratulations " + playerSymbol);
                       end = false;
                   }
                   boolean diagonalWinner = diagonalCheck(board, playerSymbol);
                   if (diagonalWinner) {
                       System.out.println("Congratulations " + playerSymbol);
                       end = false;
                   }
                   boolean columnWinner = columnCheck(board, playerSymbol);
                   if (columnWinner) {
                       System.out.println("Congratulations " + playerSymbol);
                       end = false;
                   }
                   boolean diagonalWinner2 = diagonalCheck2(board, playerSymbol);
                   if (diagonalWinner2) {
                       System.out.println("Congratulations " + playerSymbol);
                       end = false;
                   }

                   playerSymbol = playerSymbol == 'X' ? 'O' : 'X';

               }

            if(!correctMovement){
                System.out.println("Bad move");
            }

       }
    }
    public static boolean diagonalCheck2(char[][] board, char symbol){ ////the program checks if the player won second diagonally

        int dimension = board.length;

        for (int i=0; i<dimension; i++){
            if(board[i][dimension -i - 1] !=symbol){
                return false;
            }
        }
        return true;


    }


    public static boolean columnCheck(char[][] plansza, char symbol){ // the program check if the player won by the column
        int dimension = plansza.length;
        for(int column=0; column<dimension; column++){
            boolean winner = true;
            for (int row =0; row<dimension; row++ ){
                if(plansza[row][column] !=symbol){
                    winner = false;
                    break;
                }
            }
            if(winner){
                return true;
            }
        }
        return false;

    }

    public static boolean diagonalCheck(char[][] board, char symbol){ //the program checks if the player won diagonally

        int dimension = board.length;
        for (int i=0; i< dimension; i++){
            if(board[i][i] != symbol){
                return false;
            }
        }
        return true;

    }

    public static boolean rowCheck(char [][] board, char symbol) { // the program checks if the playwr has won by the line

        int dimension = board.length;
        for (int row = 0; row < dimension; row++) {
            boolean win = true;
            for (int column = 0; column < dimension; column++) {
                if (board[row][column] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public static boolean makeAMove(char [][] board, char symbol){ //the program makes a move on the board
        System.out.println(symbol + " your move");
        System.out.println("Enter the row number");
        int row = new Scanner(System.in).nextInt();
        System.out.println("Enter the column number");
        int column = new Scanner(System.in).nextInt();
      while (true){
            try {
                boolean correctMovement = board[row][column] == 0;
                if (!correctMovement) {
                    System.out.println(" Incorrect move ");
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index outside the acceptable limits" + e);
                System.out.println("Enter a valid value");
            return false;
            }

          board[row][column] = symbol;
          return true;
      }
    }

    public static void printCharts(char[][]board){ // the program prints the charts
        int dimension = board.length;
        System.out.print("\t");
        for (int i=0; i<dimension;i++){
            System.out.print(i +"\t");
        }
        System.out.println();
        for(int row=0; row<board.length; row++){
            System.out.print(row + ":\t");
            for (int column = 0; column<board[row].length; column++){
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }

}















