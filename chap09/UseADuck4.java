package chap09;

class Duck4 {
    int size;
    boolean canFly;

    // No-argument constructor
    public Duck4() {
        this.size = 5;
        this.canFly = true;
        System.out.println("Default Duck created.");
    }

    // Constructor with size parameter
    public Duck4(int size) {
        this.size = size;
        this.canFly = true;
        System.out.println("Duck created with size: " + size);
    }

    // Constructor with size and canFly parameters
    public Duck4(int size, boolean canFly) {
        this.size = size;
        this.canFly = canFly;
        System.out.println("Duck created with size: " + size + " and canFly: " + canFly);
    }
}

public class UseADuck4 {
    public static void main(String[] args) {
        Duck4 d1 = new Duck4();                           // Calls no-argument constructor
        Duck4 d2 = new Duck4(10);                    // Calls constructor with size parameter
        Duck4 d3 = new Duck4(15, false);      // Calls constructor with size and canFly parameters
    }
}

