package jadvanced.chap15.Page520;
// Declares the package name where this class is stored

import javax.swing.*;
import java.awt.*;
// Imports the Swing and AWT libraries needed for GUI components and layouts

public class Panel1 {
    // Defines the main class called Panel1

    public static void main(String[] args) {
        // The main method — program execution starts here
        Panel1 gui = new Panel1();   // Creates an instance of the Panel1 class
        gui.go();                    // Calls the go() method to build and display the GUI
    }

    public void go() {
        // Method that creates and sets up the graphical user interface

        JFrame frame = new JFrame();
        // Creates a new window (a JFrame) that will hold all components

        JPanel panel = new JPanel();
        // Creates a panel to group buttons or other components together

        panel.setBackground(Color.darkGray);
        // Sets the background color of the panel to dark gray

        JButton button = new JButton("shock me");
        // Creates a button labeled "shock me"

        JButton buttonTwo = new JButton("bliss");
        // Creates another button labeled "bliss"

        panel.add(button);
        // Adds the first button to the panel
        panel.add(buttonTwo);
        // Adds the second button to the panel

        frame.getContentPane().add(BorderLayout.EAST, panel);
        // Adds the panel to the right side (EAST) of the frame’s layout

        frame.setSize(200, 200);
        // Sets the window size to 200x200 pixels

        frame.setVisible(true);
        // Makes the frame visible on the screen
    }
}
