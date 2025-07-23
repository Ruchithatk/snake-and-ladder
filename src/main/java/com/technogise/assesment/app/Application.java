package com.technogise.assesment.app;

import com.technogise.assesment.board.Board;
import com.technogise.assesment.board.BoardFactory;
import com.technogise.assesment.game.*;
import com.technogise.assesment.logic.GameLogic;
import com.technogise.assesment.logic.GameLogicFactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = BoardFactory.createBoard();
        GameLogic gameLogic = GameLogicFactory.getDefaultGameLogic();
        Game game = GameFactory.createGame(board, gameLogic);

        System.out.println("Welcome to Snakes & Ladders!");
        System.out.println("Input format: currentPosition,diceRoll (e.g., 34,3)");
        System.out.println("Type 'exit' to quit.");

        runGameLoop(scanner, game);

        scanner.close();
    }

    public static void runGameLoop(Scanner scanner, Game game) {
        int currentPosition;
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
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Please provide both current position and dice roll.");
                System.out.println("Example format: currentPosition,diceRoll (e.g., 34,3)");
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid integers for both current position and dice roll.");
                System.out.println("Example format: currentPosition,diceRoll (e.g., 34,3)");
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter in correct format: currentPosition,diceRoll (e.g., 34,3)");
            }
        }
    }
}
