package chap04;

// A simple class representing a Horse
class Horse {
    // Instance variables (private = can only be accessed within this class)
    private double height = 15.2;  // initialized with a default value
    private String breed;          // will default to null if not set

    // More methods/constructors could be added here...
}

// A class that adds two integers
class AddThing {
    int a;        // defaults to 0 if not initialized
    int b = 12;   // explicitly initialized with 12

    // Method that adds 'a' and 'b'
    public int add() {
        int total = a + b;  // calculate the sum
        return total;       // return the result
    }
}

// Demonstrates local variable rules
class Foo {
    public void go() {
        int x;
        // Local variables (like 'x') MUST be initialized before use!
        // If you uncomment the line below, it will NOT compile,
        // because 'x' has no value assigned yet.
        // int z = x + 3;
    }
}

// The main driver class
public class TestClasses {
    public static void main(String[] args) {
        // Create an AddThing object
        AddThing at = new AddThing();

        // Set the value of 'a' to 5
        at.a = 5;

        // Call the add() method → 5 + 12 = 17
        System.out.println("Sum is: " + at.add());
    }
}


