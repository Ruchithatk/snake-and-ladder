package com.technogise.assesment.game;

import com.technogise.assesment.board.Board;
import com.technogise.assesment.logic.GameLogic;

public class Game {
    private final Board board;
    private final GameLogic gameLogic;

    public Game(Board board, GameLogic gameLogic) {
        this.board = board;
        this.gameLogic = gameLogic;
    }

    public int play(int currentPosition, int diceRoll) {
        validateCurrentPosition(currentPosition);
        validateDiceRoll(diceRoll);

        int newPosition = currentPosition + diceRoll;
        if (newPosition > Board.WINNING_POSITION) {
            return handleExceedingPosition(currentPosition);
        }
        else if (newPosition == Board.WINNING_POSITION) {
            return handleWinningPosition();
        }

        int finalPosition = gameLogic.determineFinalPosition(board, newPosition);
        System.out.println("New position: " + finalPosition);

        return finalPosition;
    }

    private void validateCurrentPosition(int currentPosition) {
        if (currentPosition < 0 || currentPosition > 99) {
            throw new IllegalArgumentException("Current Position must be between 0 and 99");
        }
    }

    private static int handleWinningPosition() {
        System.out.println("You won!!");
        return Board.WINNING_POSITION;
    }

    private static int handleExceedingPosition(int currentPosition) {
        System.out.println("New position would exceed 100. Staying at position " + currentPosition);
        return currentPosition;
    }

    private void validateDiceRoll(int diceRoll) {
        if (diceRoll < 1 || diceRoll > 6) {
            throw new IllegalArgumentException("Dice roll must be between 1 and 6");
        }
    }
}
