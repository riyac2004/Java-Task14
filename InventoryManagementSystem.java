import java.io.*;
import java.util.*;

public class InventoryManagementSystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();
    static final String FILE_NAME = "inventory.txt";

    public static void main(String[] args) {

        loadFromFile();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Inventory Management System ====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Products");
            System.out.println("5. Inventory Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Enter numbers only.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> updateProduct(sc);
                case 3 -> deleteProduct(sc);
                case 4 -> viewProducts();
                case 5 -> showSummary();
                case 6 -> {
                    saveToFile();
                    System.out.println("Data saved. Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    // ADD PRODUCT
    static void addProduct(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (inventory.containsKey(id)) {
            System.out.println("❌ Product ID already exists.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product = new Product(id, name, quantity, price);
        inventory.put(id, product);

        System.out.println("✅ Product added successfully.");
    }

    // UPDATE PRODUCT
    static void updateProduct(Scanner sc) {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        if (!inventory.containsKey(id)) {
            System.out.println("❌ Product not found.");
            return;
        }

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter New Price: ");
        double price = sc.nextDouble();

        Product p = inventory.get(id);
        p.quantity = quantity;
        p.price = price;

        System.out.println("✅ Product updated.");
    }

    // DELETE PRODUCT
    static void deleteProduct(Scanner sc) {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (inventory.remove(id) != null) {
            System.out.println("✅ Product deleted.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // VIEW PRODUCTS
    static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n--- Product List ---");
        for (Product p : inventory.values()) {
            System.out.println("ID: " + p.id +
                    ", Name: " + p.name +
                    ", Qty: " + p.quantity +
                    ", Price: " + p.price);
        }
    }

    // INVENTORY SUMMARY
    static void showSummary() {
        int totalItems = 0;
        double totalValue = 0;

        for (Product p : inventory.values()) {
            totalItems += p.quantity;
            totalValue += p.getTotalValue();
        }

        System.out.println("\n--- Inventory Summary ---");
        System.out.println("Total Products: " + inventory.size());
        System.out.println("Total Quantity: " + totalItems);
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // SAVE TO FILE
    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : inventory.values()) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // LOAD FROM FILE
    static void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int quantity = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);

                inventory.put(id, new Product(id, name, quantity, price));
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
