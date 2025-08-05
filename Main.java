class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
        setStock(stock);
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("❌ Price cannot be negative.");
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("❌ Stock cannot be negative.");
        }
    }
}

class User {
    protected int userId;
    protected String username;
    protected String email;

    public User(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }
}

class Customer extends User {
    public Customer(int userId, String username, String email) {
        super(userId, username, email);
    }

    public void placeOrder(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            System.out.println("✅ " + username + " placed an order for " + quantity + " x " + product.getName());
            product.setStock(product.getStock() - quantity);
        } else {
            System.out.println("❌ Not enough stock for " + product.getName());
        }
    }
}

class Admin extends User {
    public Admin(int userId, String username, String email) {
        super(userId, username, email);
    }

    public void updateProduct(Product product, String name, double price, int stock) {
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        System.out.println("🛠 " + username + " updated product " + product.getProductId());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a product
        Product product1 = new Product(1, "Phone", 500.0, 5);

        // Create a customer
        Customer customer = new Customer(101, "Kero", "kero@example.com");

        // Create an admin
        Admin admin = new Admin(999, "AdminUser", "admin@example.com");

        // Customer places an order
        customer.placeOrder(product1, 2);

        // Admin updates the product
        admin.updateProduct(product1, "Smartphone", 550.0, 10);

        // Customer places another order
        customer.placeOrder(product1, 3);
    }
}