package com.nisum.secret.game;


public class Board {


    private boolean empty = true;


    public boolean isFinished() {
        return false;
    }


    public boolean isEmpty() {
        return empty;
    }


    public void move(int x, int y, String symbol) {
        if (!empty) {
            throw new IllegalMoveException();
        } else {
            empty = false;
        }
    }


    public class IllegalMoveException extends RuntimeException {

    }
}

