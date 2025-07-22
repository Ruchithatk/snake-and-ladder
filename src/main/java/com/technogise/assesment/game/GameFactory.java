package com.technogise.assesment.game;

import com.technogise.assesment.board.Board;
import com.technogise.assesment.logic.GameLogic;

public class GameFactory {
    public static Game createGame(Board board, GameLogic gameLogic) {
        return new Game(board, gameLogic);
    }
}
