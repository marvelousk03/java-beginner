package shopping;

import java.util.ArrayList;
import java.util.Scanner;

// Launcher class
public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.start();
    }
}

// Represents the shopping cart
class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean shopping = true;

        System.out.println("🛒 Welcome to the Simple Shopping Cart!");

        while (shopping) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add item");
            System.out.println("2. View cart");
            System.out.println("3. Checkout & Exit");
            System.out.print("👉 Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                addItem();
            } else if (choice == 2) {
                viewCart();
            } else if (choice == 3) {
                checkout();
                shopping = false;
            } else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        String priceInput = scanner.nextLine();     // read as text
        double price = Double.parseDouble(priceInput); // convert safely

        Item item = new Item(name, price);
        items.add(item);

        System.out.println("✅ " + name + " added to cart!");
    }

    private void viewCart() {
        if (items.isEmpty()) {
            System.out.println("🛍️ Your cart is empty.");
            return;
        }

        System.out.println("\n🛒 Items in your cart:");
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    private void checkout() {
        if (items.isEmpty()) {
            System.out.println("🛍️ Your cart is empty. Nothing to checkout.");
        } else {
            viewCart();
            System.out.println("💳 Thank you for shopping with us!");
        }
    }
}

// Represents an item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
