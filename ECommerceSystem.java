import java.util.ArrayList;

// Product Class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
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

// Order Class (Aggregates multiple Products)
class Order {
    private int orderId;
    private ArrayList<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("  - " + products.get(i).getName() + " (Rs. " + products.get(i).getPrice() + ")");
        }
    }
}

// Customer Class (Has an association with Order)
class CustomerInfo {
    private String name;
    private ArrayList<Order> orders;

    public CustomerInfo(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Customer: " + name);
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).displayOrder();
            System.out.println();
        }
    }
}

// Main Class
public class ECommerceSystem {
    public static void main(String[] args) {
        // Creating Products
        Product p1 = new Product("Laptop", 56000);
        Product p2 = new Product("Phone", 3500);
        Product p3 = new Product("Headphones", 1000);

        // Creating Orders
        Order o1 = new Order(101);
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = new Order(102);
        o2.addProduct(p2);

        // Creating Customer
        CustomerInfo c1 = new CustomerInfo("Sanya");
        c1.placeOrder(o1);
        c1.placeOrder(o2);

        // Display Customer's Orders
        c1.displayOrders();
    }
}


/*
O/P ->
Customer: Sanya
Order ID: 101
Products:
  - Laptop (Rs. 56000.0)
  - Headphones (Rs. 1000.0)

Order ID: 102
Products:
  - Phone (Rs. 3500.0)
 */