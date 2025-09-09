package chap05;

// Main class for running the Simple Startup game
public class SimpleStartupGame {
    public static void main(String[] args) {
        // Keep track of how many guesses the player makes
        int numOfGuesses = 0;

        // Create a GameHelper object to handle user input
        GameHelper helper = new GameHelper();

        // Create a new SimpleStartup object (the "ship")
        SimpleStartup theStartup = new SimpleStartup();

        // Generate a random starting position for the ship (0–4)
        // Ship takes up 3 consecutive cells, so starting at 5 would go out of bounds
        int randomNum = (int) (Math.random() * 5);

        // Assign the ship's location cells based on the random starting number
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        theStartup.setLocationCells(locations);

        // Flag to keep the game running until the ship is sunk
        boolean isAlive = true;

        // Game loop – keeps asking for guesses until the ship is "killed"
        while (isAlive) {
            // Ask the player for a guess (input comes from GameHelper)
            int guess = helper.getUserInput("enter a number");

            // Check the guess against the ship’s location
            String result = theStartup.checkYourself(guess);

            // Increment number of guesses made
            numOfGuesses++;

            // If the ship is sunk, end the game
            if (result.equals("kill")) {
                isAlive = false; // stop the loop
                System.out.println("You took " + numOfGuesses + " guesses");
            } // close if
        } // close while
    } // close main
} // close class

