import java.io.Serializable;

class Product implements Serializable {
    int id;
    String name;
    int quantity;
    double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }
}
