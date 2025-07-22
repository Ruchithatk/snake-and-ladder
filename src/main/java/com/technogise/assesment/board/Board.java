package com.technogise.assesment.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
    public static final int WINNING_POSITION = 100;

    private static Board instance;

    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = new HashMap<>(snakes);
        this.ladders = new HashMap<>(ladders);
    }

    public static Board getInstance(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        if (instance == null) {
            instance = new Board(snakes,ladders);
        }
        return instance;
    }

    public Map<Integer, Integer> getSnakes() {
        return Collections.unmodifiableMap(snakes);
    }

    public Map<Integer, Integer> getLadders() {
        return Collections.unmodifiableMap(ladders);
    }
}
