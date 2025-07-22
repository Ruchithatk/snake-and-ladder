# snakes-and-ladders

Assumptions:

- The game is played on a board with 100 squares.
- The board has 4 snakes and 4 ladders, which are predefined.
- The game ends when the player reaches exactly position 100.
- If the dice roll results in a position greater than 100, the player remains at the current position.
- The game is played by a single player at any given time.
- The player current position and the dice roll value will be provided as input and are not tracked.
- The game terminates when the player has won or `exit` has been entered in the input prompt.

Usage:

- Clone the repository.
- Ensure you have Java 17+ installed.
- Import the project into an IDE (IntelliJ IDEA recommended).
- Build the project using Gradle by running `./gradlew build` in the terminal.
- Run the `Main` class to start the game.
- Input the current position and dice roll value when prompted.(e.g., `5,3` for position 5 and dice roll 3).
- Output will be displayed in the console.
- Type `exit` to terminate the game forcefully.