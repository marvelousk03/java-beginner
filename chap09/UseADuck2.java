package chap09;

class Duck2 {
    int size;

    public Duck2(int duckSize) {
        System.out.println("Quack");
        size = duckSize;  // Initialize size using constructor parameter
        System.out.println("size is " + size);
    }
}

public class UseADuck2 {
    public static void main(String[] args) {
        Duck2 d = new Duck2(42);  // Create and initialize in one step
    }
}


