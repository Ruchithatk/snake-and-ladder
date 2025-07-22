package com.technogise.assesment.board;

import java.util.HashMap;
import java.util.Map;

public class BoardBuilder {
    private final Map<Integer, Integer> snakes = new HashMap<>();
    private final Map<Integer, Integer> ladders = new HashMap<>();

    public BoardBuilder addSnake(int head, int tail) {
        snakes.put(head, tail);
        return this;
    }

    public BoardBuilder addLadder(int foot, int top) {
        ladders.put(foot, top);
        return this;
    }

    public Board build() {
        return Board.getInstance(snakes,ladders);
    }
}
