package jadvanced.chap16.Page576;

/**
 * The QuizCard class represents a single flashcard-like object
 * that holds a question and its corresponding answer.
 *
 * This class is a simple data model used by the OldStyle class
 * to create and save quiz cards to a file.
 */
public class QuizCard {
    // Fields (instance variables) to store the question and answer text
    private String question;
    private String answer;

    /**
     * Constructor to initialize a QuizCard object with a question and an answer.
     *
     * @param q The question text.
     * @param a The answer text.
     */
    public QuizCard(String q, String a) {
        question = q;
        answer = a;
    }

    /**
     * Returns the question text of the quiz card.
     *
     * @return the question string.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Returns the answer text of the quiz card.
     *
     * @return the answer string.
     */
    public String getAnswer() {
        return answer;
    }
}
