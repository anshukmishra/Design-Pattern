package behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(int amount);
};

// Credit Card Payment Strategy
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

// PayPal Payment Strategy
class PayPalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PayPalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
};

// Bitcoin Payment Strategy
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Bitcoin.");
    }
};

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
};

class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
};

public class StrategyDesignExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Book", 100);
        Item item2 = new Item("Pen", 50);

        cart.addItem(item1);
        cart.addItem(item2);

        // Pay using Credit Card
        cart.pay(new CreditCardPayment("John Doe", "1234567890123456", "786", "12/25"));

        // Pay using PayPal
        cart.pay(new PayPalPayment("john@example.com", "password"));

        // Pay using Bitcoin
        cart.pay(new BitcoinPayment("1AB23C45D67E89F01234G567H89J01K2L"));
    }
};
