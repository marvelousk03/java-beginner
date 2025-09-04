package chap04; // Defines the package this class belongs to

// A simple class representing a dog with size and name attributes
class PoorDog {
    // Instance variables (private = only accessible inside this class)
    private int size;      // Dog's size (default value = 0 if not set)
    private String name;   // Dog's name (default value = null if not set)

    // Getter method for size
    public int getSize() {
        return size; // Returns the value of size
    }

    // Getter method for name
    public String getName() {
        return name; // Returns the value of name
    }
}

// Test class with main method to run the program
public class PoorDogTestDrive {
    public static void main(String[] args) {
        // Create a new PoorDog object called 'one'
        PoorDog one = new PoorDog();

        // Print the size of the dog (will be 0 because not initialized)
        System.out.println("Dog size is " + one.getSize());

        // Print the name of the dog (will be null because not initialized)
        System.out.println("Dog name is " + one.getName());
    }
}
