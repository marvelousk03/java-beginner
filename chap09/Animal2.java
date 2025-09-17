package chap09;

// This is an abstract class called Animal
// All animals will have a name and a way to get that name
public abstract class Animal2 {

    // Private instance variable to store the animal's name
    private String name;

    // Constructor that takes a name and assigns it to the instance variable
    public Animal2(String theName) {
        name = theName;
    }

    // Getter method to return the name of the animal
    public String getName() {
        return name;
    }
}

