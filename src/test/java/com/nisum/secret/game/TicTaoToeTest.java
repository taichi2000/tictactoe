package com.nisum.secret.game;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicTaoToeTest {

    private Board board;


    @Before
    public void setUp() throws Exception {
        board = new Board();
    }


    @Test
    public void newBoardShouldBeNonFinished() throws Exception {
        assertThat(board.isFinished(), is(false));
    }


    @Test
    public void newBoardShouldBeEmpty() throws Exception {
        assertThat(board.isEmpty(), is(true));
    }


    @Test
    public void afterFirstMoveBoardIsNotEmpty() throws Exception {
        board.move(1, 1, "X");

        assertThat(board.isEmpty(), is(false));
    }


    @Test(expected = Board.IllegalMoveException.class)
    public void shouldNotMoveOnSamePositionTwice() throws Exception {
        board.move(1, 1, "X");
        board.move(1, 1, "O");

    }
}