package com.technogise.assesment.core;

import com.technogise.assesment.logic.GameLogic;

public class Game {
    private final Board board;
    private final GameLogic gameLogic;

    public Game(Board board, GameLogic gameLogic) {
        this.board = board;
        this.gameLogic = gameLogic;
    }

    public int play(int currentPosition, int diceRoll) {
        if (diceRoll < 1 || diceRoll > 6) {
            throw new IllegalArgumentException("Dice roll must be between 1 and 6");
        }

        int newPosition = currentPosition + diceRoll;
        if (newPosition > Board.WINNING_POSITION) {
            System.out.println("New position would exceed 100. Staying at position " + currentPosition);
            return currentPosition;
        }
        else if (newPosition == Board.WINNING_POSITION) {
            System.out.println("Yay!! You won!!");
            return newPosition;
        }

        int finalPosition = gameLogic.getFinalPosition(board, newPosition);
        System.out.println("New position: " + finalPosition);

        return finalPosition;
    }
}
