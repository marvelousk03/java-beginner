import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MiniTaskTracker extends JFrame {
    private ArrayList<String> tasks = new ArrayList<>();
    private JTextArea displayArea;
    private JTextField inputField;

    public MiniTaskTracker() {
        super("Mini Task Tracker 🧠");

        // Layout
        setLayout(new BorderLayout());

        // Input area
        inputField = new JTextField(20);
        JButton addButton = new JButton("Add Task");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Task:"));
        topPanel.add(inputField);
        topPanel.add(addButton);

        // Display area
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Lambda listener (Chapter 12)
        addButton.addActionListener(e -> addTask());

        // Close behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private void addTask() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a task!");
            return;
        }

        // Chapter 11: Using ArrayList
        tasks.add(text);
        inputField.setText("");
        refreshDisplay();
    }

    private void refreshDisplay() {
        displayArea.setText("");
        // Chapter 12: forEach lambda
        tasks.forEach(task -> displayArea.append("- " + task + "\n"));
    }

    public static void main(String[] args) {
        // Chapter 14: Swing GUI runs on the event thread
        SwingUtilities.invokeLater(() -> new MiniTaskTracker());
    }
}
