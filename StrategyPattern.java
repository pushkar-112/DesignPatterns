package DesignPatterns;

// Behavioral  Pattern
    // Structural Design Pattern
    // Encapsulates behavior
    // Allow dynamic/runtime switching of behavior
    // USED WHEN --> When behavior needs to be interchangeable at runtime

// Requirements:
    // Multiple type of payments - Card, UPI, Wallet

public class StrategyPattern {

    public static void main(String[] args){
        System.out.println("Hello");

        PaymentStrategy strategy = new UPIPaymentS();
        // Context uses the strategy
        PaymentContext context = new PaymentContext(strategy);
        context.executePayment();

        // Change strategy at runtime
        context.setStrategy(new CardPaymentS());
        context.executePayment();
    }
}

class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment() {
        strategy.pay();
    }
}

interface PaymentStrategy {
    void pay();
}

class CardPaymentS implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("Card Payment");
    }
}

class UPIPaymentS implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("UPI Payment");
    }
}

