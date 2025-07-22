package com.technogise.assesment.core;

import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int WINNING_POSITION = 100;

    private static Board instance;

    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    private Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int foot, int top) {
        ladders.put(foot, top);
    }

    public Map<Integer, Integer> getSnakes() {
        return new HashMap<>(snakes);
    }

    public Map<Integer, Integer> getLadders() {
        return new HashMap<>(ladders);
    }
}
