package com.technogise.assesment.core;

public class BoardFactory {
    public static Board createStandardBoard() {
        Board board = Board.getInstance();
        board.addLadder(7, 33);
        board.addLadder(37, 85);
        board.addLadder(51, 72);
        board.addLadder(22, 58);

        board.addSnake(36, 19);
        board.addSnake(65, 35);
        board.addSnake(87, 32);
        board.addSnake(98, 75);

        return board;
    }
}
