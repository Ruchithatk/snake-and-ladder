package com.technogise.assesment;

import com.technogise.assesment.core.Board;
import com.technogise.assesment.core.BoardFactory;
import com.technogise.assesment.core.Game;
import com.technogise.assesment.logic.DefaultGameLogic;
import com.technogise.assesment.logic.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Board board;
    private GameLogic gameLogic;
    private Game game;

    @BeforeEach
    void setUp() {
        board = BoardFactory.createStandardBoard();
        gameLogic = new DefaultGameLogic();
        game = new Game(board, gameLogic);
    }

    @Test
    void testPlayerWinsAtExact100() {
        int finalPos = game.play(99, 1);
        assertEquals(100, finalPos);
    }

    @Test
    void testDiceRollBeyond100KeepsCurrentPosition() {
        int finalPos = game.play(98, 5);
        assertEquals(98, finalPos);
    }

    @Test
    void testSnakeBite() {
        int finalPos = game.play(83, 4);
        assertEquals(32, finalPos);
    }

    @Test
    void testLadderClimb() {
        int finalPos = game.play(34, 3);
        assertEquals(85, finalPos);
    }

    @Test
    void testNormalMove() {
        int finalPos = game.play(4, 5);
        assertEquals(9, finalPos);
    }

    @Test
    void testInvalidDiceRollThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> game.play(50, 0));
        assertThrows(IllegalArgumentException.class, () -> game.play(50, 7));
        assertThrows(IllegalArgumentException.class, () -> game.play(50, -1));
    }
}
