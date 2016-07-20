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
    public void newBoardGameShouldBeNonFinished() throws Exception {
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


    @Test
    public void whenXIsPlayedXisAtGivenCoordinates() throws Exception {
        board.move(1, 1, "X");

        assertThat(board.getValueAt(1, 1), is("X"));
    }


    @Test
    public void whenXAndOArePlayedXAndOAreAtGivenCoordinates() throws Exception {
        board.move(1, 1, "X");
        board.move(1, 2, "O");

        assertThat(board.getValueAt(1, 1), is("X"));
        assertThat(board.getValueAt(1, 2), is("O"));
    }


    @Test(expected = Board.IllegalMoveException.class)
    public void shouldNotMoveOnSamePositionTwice() throws Exception {
        board.move(1, 1, "X");
        board.move(1, 1, "O");
    }


    @Test
    public void afterSecondMoveBoardIsNotEmpty() throws Exception {
        board.move(1, 1, "X");
        board.move(1, 2, "O");

        assertThat(board.isEmpty(), is(false));
    }


    @Test
    public void after5MovesGameIsFinished() throws Exception {
        /**
         * XXX
         * OO-
         * ---
         */
        board.move(1, 1, "X");
        board.move(2, 1, "O");
        board.move(1, 2, "X");
        board.move(2, 2, "O");
        board.move(1, 3, "X");

        assertThat(board.isFinished(), is(true));

    }
}