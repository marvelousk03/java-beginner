package chap09;

// It inherits from the Animal class
public class Hippo2 extends Animal2 {

    // Constructor for Hippo that takes a name
    // Calls the constructor of Animal using 'super'
    public Hippo2(String name) {
        super(name); // Passes the name to the Animal constructor
    }
}

