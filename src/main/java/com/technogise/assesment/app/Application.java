package com.technogise.assesment.app;

import com.technogise.assesment.core.Board;
import com.technogise.assesment.core.BoardFactory;
import com.technogise.assesment.logic.DefaultGameLogic;
import com.technogise.assesment.logic.GameLogic;
import com.technogise.assesment.core.Game;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = BoardFactory.createStandardBoard();
        GameLogic gameLogic = new DefaultGameLogic();
        Game game = new Game(board,gameLogic);

        int currentPosition = 0;

        System.out.println("Welcome to Snakes & Ladders!");
        System.out.println("Input format: currentPosition,diceRoll (e.g., 34,3)");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("Enter input: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String[] parts = input.split(",");
                int pos = Integer.parseInt(parts[0].trim());
                int roll = Integer.parseInt(parts[1].trim());

                currentPosition = game.play(pos, roll);

                if (currentPosition == Board.WINNING_POSITION) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter in format: currentPosition,diceRoll");
            }
        }

        scanner.close();
    }
}
