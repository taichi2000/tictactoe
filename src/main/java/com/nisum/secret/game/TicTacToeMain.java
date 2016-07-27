package com.nisum.secret.game;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TicTacToeMain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("  TIC-TAC-TOE GAME");
        System.out.println("-----------------------");
        System.out.println("Please select a option");
        System.out.println();
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        switch (scanner.nextInt()){
            case 1:
                Board board = new Board();
                scanner.nextLine();
                while (board.isFinished()!=true){
                    board.printBoard();
                    System.out.println("Choose the number position like X,Y and then the symbol. Ex: 1 2 X");
                    String line = scanner.nextLine();
                    StringTokenizer stk = new StringTokenizer(line," ");
                    while (stk.hasMoreTokens()){
                        int x = Integer.parseInt(stk.nextToken());
                        int y = Integer.parseInt(stk.nextToken());
                        String symbol = stk.nextToken();
                        board.move(x,y,symbol);
                    }
                }
                board.printBoard();
                System.out.println("The Game is finished");
                System.out.println("Numbers of moves: "+board.getNumbersOfMoves());
                System.out.println("Thanks for played :D");
                break;
            case 2:
                System.exit(0);
                break;
        }

    }
}
