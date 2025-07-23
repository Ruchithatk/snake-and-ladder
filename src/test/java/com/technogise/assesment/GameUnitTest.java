package com.technogise.assesment;

import com.technogise.assesment.board.Board;
import com.technogise.assesment.board.BoardFactory;
import com.technogise.assesment.game.Game;
import com.technogise.assesment.game.GameFactory;
import com.technogise.assesment.logic.GameLogic;
import com.technogise.assesment.logic.GameLogicFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameUnitTest {

    private Board board;
    private GameLogic gameLogic;
    private Game game;

    @BeforeEach
    void setUp() {
        board = BoardFactory.createBoard();
        gameLogic = GameLogicFactory.getDefaultGameLogic();
        game = GameFactory.createGame(board, gameLogic);
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
