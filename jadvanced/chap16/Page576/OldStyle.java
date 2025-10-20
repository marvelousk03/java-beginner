package jadvanced.chap16.Page576;

import java.io.*;
import java.util.*;

/**
 * The OldStyle class demonstrates how to save a list of QuizCard objects
 * (each containing a question and answer) to a text file using
 * traditional Java I/O (BufferedWriter and FileWriter).
 */
public class OldStyle {

    // A list to hold QuizCard objects
    private List<QuizCard> cardList = new ArrayList<>();

    /**
     * The main method serves as the entry point of the program.
     * It creates an instance of OldStyle, adds a QuizCard to the list,
     * and saves it to a text file.
     */
    public static void main(String[] args) {
        // Create an instance of OldStyle
        OldStyle builder = new OldStyle();

        // Add a QuizCard with a sample question and answer
        builder.cardList.add(new QuizCard(
                "What is the purpose of books?",
                "to provide knowledge, entertainment, and a means for personal growth by educating readers, " +
                        "stimulating creativity, and fostering empathy through stories and information."
        ));

        builder.cardList.add(new QuizCard(
                "What is Java?",
                "A programming language."
        ));

        builder.cardList.add(new QuizCard(
                "What is Java?",
                "Java is a popular, object-oriented, and multi-platform programming language that runs on billions of devices, including computers, mobile phones, and gaming consoles"
        ));

        // Save the list of QuizCards to a file
        builder.saveFile(new File("C:\\Bootcamp\\javab\\my_code\\javab\\src\\jadvanced\\chap16\\Page576\\old_quizcards.txt"));
    }

    /**
     * Saves all QuizCard objects in the cardList to the specified file.
     * Each QuizCard is written as "question/answer" on a new line.
     *
     * @param file the File object representing the file to write to
     */
    private void saveFile(File file) {
        BufferedWriter writer = null; // Writer for writing text to file

        try {
            // Create a BufferedWriter to write efficiently to the file
            writer = new BufferedWriter(new FileWriter(file));

            // Iterate over each QuizCard in the list and write to file
            for (QuizCard card : cardList) {
                // Write the question followed by a slash ("/") as a delimiter
                writer.write(card.getQuestion() + "/");

                // Write the answer followed by a newline
                writer.write(card.getAnswer() + "\n");
            }
        } catch (IOException e) {
            // Handle any file-writing errors
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        } finally {
            // Always attempt to close the writer to release resources
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                // Handle any error that occurs while closing the writer
                System.out.println("Couldn't close writer: " + e.getMessage());
            }
        }
    }
}
