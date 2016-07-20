package com.nisum.secret.game;


public class Board {

    private boolean empty = true;
    private String[][] matrix = new String[3][3];


    public boolean isFinished() {
        if (allCellsAreOccupied())
            return true;

        return thereIsThreeElementsInARow();
    }


    private boolean allCellsAreOccupied() {
        return false;
    }


    private boolean thereIsThreeElementsInARow() {
        String pos11 = matrix[0][0];
        String pos12 = matrix[0][1];
        String pos13 = matrix[0][2];
        String pos21 = matrix[1][0];
        String pos22 = matrix[1][1];
        String pos23 = matrix[1][2];
        String pos31 = matrix[2][0];
        String pos32 = matrix[2][1];
        String pos33 = matrix[2][2];

        return
                pos11.equals(pos12) && pos11.equals(pos13) ||
                pos21.equals(pos22) && pos21.equals(pos23) ||
                pos31.equals(pos32) && pos31.equals(pos33) ||
                pos11.equals(pos21) && pos11.equals(pos31) ||

                pos11.equals(pos21) && pos11.equals(pos31) ||
                pos12.equals(pos22) && pos12.equals(pos32) ||
                pos13.equals(pos23) && pos13.equals(pos33) ||

                pos11.equals(pos22) && pos11.equals(pos33) ||
                pos31.equals(pos22) && pos31.equals(pos13);
    }


    public boolean isEmpty() {
        return empty;
    }


    public void move(int x, int y, String symbol) {
        if (matrix[x - 1][y - 1] != null) {
            throw new IllegalMoveException();
        }

        matrix[x - 1][y - 1] = symbol;

        empty = false;
    }


    public String getValueAt(int x, int y) {
        return matrix[x - 1][y - 1];
    }


    public class IllegalMoveException extends RuntimeException {

    }
}

