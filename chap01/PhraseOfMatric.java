package chap01;

public class PhraseOfMatric {
    public static void main(String[] args) {
        // First group of descriptive words
        String[] wordListOne = {
                "happy", "bright", "fast", "small", "fun", "brave", "quiet"
        };

        // Second group of color words
        String[] wordListTwo = {
                "red", "blue", "green", "yellow", "pink", "orange", "purple"
        };

        // Third group of objects and animals
        String[] wordListThree = {
                "cat", "dog", "car", "ball", "tree", "book", "bird"
        };

        // Get the number of words in each list
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        // Create a random number generator
        java.util.Random randomGenerator = new java.util.Random();

        // Pick one random index from each list
        int rand1 = randomGenerator.nextInt(oneLength);
        int rand2 = randomGenerator.nextInt(twoLength);
        int rand3 = randomGenerator.nextInt(threeLength);

        // Combine the random words into a phrase
        String phrase = wordListOne[rand1] + " " +
                wordListTwo[rand2] + " " +
                wordListThree[rand3];

        // Print the final phrase to the screen
        System.out.println("What we need is a " + phrase);
    }
}
