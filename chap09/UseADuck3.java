package chap09;

class Duck3 {
    int size;

    // Constructor with no arguments sets a default size
    public Duck3() {
        size = 10;  // default size
        System.out.println("Quack Quack Quack Quack!!!");
        System.out.println("size is " + size);
    }

    // Constructor with size parameter sets the size to the given value
    public Duck3(int duckSize) {
        size = duckSize;
        System.out.println("Quack Quack");
        System.out.println("size is " + size);
    }
}

public class UseADuck3 {
    public static void main(String[] args) {
        Duck3 defaultDuck = new Duck3();      // Uses default size
        Duck3 customDuck = new Duck3(42);     // Uses specified size
    }
}
