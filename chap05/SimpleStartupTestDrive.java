package chap05;

// Main class to test the SimpleStartup game logic
public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        // Create a new SimpleStartup object (the target for the game)
        SimpleStartup dot = new SimpleStartup();

        // Define the "location" of the target (the cells where the ship lives)
        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        // Simulate a user guess (the player guesses position 2)
        int userGuess = 2;

        // Call checkYourself() to see if the guess is a hit, miss, or kill
        String result = dot.checkYourself(userGuess);

        // Variable to track test results
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed"; // If guess is correct, mark as passed
        }

        // Print whether the test passed or failed
        System.out.println(testResult);
    }
}

// Class representing the "startup" (like a battleship in the game)
class SimpleStartup {
    // Array to store the ship's location cells (positions on the board)
    private int[] locationCells;

    // Counter to track how many times the ship has been hit
    private int numOfHits = 0;

    // Method to set the ship's location
    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    // Method to check if the user's guess hits, misses, or sinks (kills) the ship
    public String checkYourself(int guess) {
        // Default result is "miss"
        String result = "miss";

        // Loop through each cell in the ship's location
        for (int cell : locationCells) {
            if (guess == cell) { // If the guess matches a location cell
                result = "hit";
                numOfHits++; // Increase the number of hits
                break; // Exit loop early, no need to keep checking
            }
        }

        // If all the ship's cells have been hit, the ship is "killed"
        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        // Print the result of this guess
        System.out.println(result);

        // Return the result so the main method can check it
        return result;
    }
}
