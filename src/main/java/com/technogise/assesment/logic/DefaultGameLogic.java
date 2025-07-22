package com.technogise.assesment.logic;

import com.technogise.assesment.core.Board;

import java.util.Map;

public class DefaultGameLogic implements GameLogic {

    @Override
    public int getFinalPosition(Board board, int position) {
        Map<Integer, Integer> ladders = board.getLadders();
        Map<Integer, Integer> snakes = board.getSnakes();

        if (ladders.containsKey(position)) {
            System.out.println("Ladder up from " + position + " to " + ladders.get(position));
            return ladders.get(position);
        } else if (snakes.containsKey(position)) {
            System.out.println("Snake down from " + position + " to " + snakes.get(position));
            return snakes.get(position);
        }
        return position;
    }
}
