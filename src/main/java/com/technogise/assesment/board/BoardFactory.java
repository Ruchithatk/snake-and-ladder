package com.technogise.assesment.board;

public class BoardFactory {
    public static Board createBoard() {
        return new BoardBuilder()
                .addLadder(7, 33)
                .addLadder(37, 85)
                .addLadder(51, 72)
                .addLadder(22, 58)
                .addSnake(36, 19)
                .addSnake(65, 35)
                .addSnake(87, 32)
                .addSnake(98, 75)
                .build();
    }
}
