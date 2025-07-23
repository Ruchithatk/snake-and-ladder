package com.technogise.assesment;

import com.technogise.assesment.app.Application;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationIntegrationTest {

    @Test
    void testApplicationFlow() {
        String input = "34,3\n-1,6\n10,8\ninvalid\nexit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Application.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Welcome to Snakes & Ladders!"));
        assertTrue(output.contains("Enter input:"));
        assertTrue(output.contains("Error: Current Position must be between 0 and 99"));
        assertTrue(output.contains("Error: Dice roll must be between 1 and 6"));
        assertTrue(output.contains("Error: Please enter valid integers for both current position and dice roll"));
        assertTrue(output.contains("Please enter in correct format: currentPosition,diceRoll (e.g., 34,3)"));
        assertTrue(output.contains("New position: 85"));
        assertTrue(output.contains("Type 'exit' to quit."));
    }
}
