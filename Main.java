
class User {
    String name;
    String email;

    User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void getUserDetails() {
        System.out.println("User: " + name + ", Email: " + email);
    }
}


class Customer extends User {
    String shippingAddress;

    Customer(String name, String email, String shippingAddress) {
        super(name, email);
        this.shippingAddress = shippingAddress;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Customer: " + name + ", Email: " + email + ", Shipping Address: " + shippingAddress);
    }
}


class Admin extends User {
    String role;

    Admin(String name, String email, String role) {
        super(name, email);
        this.role = role;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Admin: " + name + ", Email: " + email + ", Role: " + role);
    }
}


class Order {
    public void placeOrder(int productId) {
        System.out.println("Order placed for product ID: " + productId);
    }

    public void placeOrder(int productId, int quantity) {
        System.out.println("Order placed for product ID: " + productId + " with quantity: " + quantity);
    }
}


interface Payment {
    void processPayment(double amount);
    boolean validateCard(String cardNumber);
}


class CreditCardPayment implements Payment {
    public boolean validateCard(String cardNumber) {
        System.out.println("Validating Credit Card: " + cardNumber);
        return cardNumber.length() == 16;
    }

    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}


class PayPalPayment implements Payment {
    public boolean validateCard(String email) {
        System.out.println("Validating PayPal account: " + email);
        return email.contains("@");
    }

    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}


public class Main {
    public static void main(String[] args) {

        User customer = new Customer("Ahmed", "ahmed@example.com", "Cairo, Egypt");
        User admin = new Admin("Mona", "mona@example.com", "Manager");

        customer.getUserDetails();
        admin.getUserDetails();

        Order order = new Order();
        order.placeOrder(101);
        order.placeOrder(101, 3);

        Payment creditPayment = new CreditCardPayment();
        if (creditPayment.validateCard("1234567890123456")) {
            creditPayment.processPayment(150.0);
        }

        Payment paypalPayment = new PayPalPayment();
        if (paypalPayment.validateCard("user@paypal.com")) {
            paypalPayment.processPayment(99.99);
        }
    }
}