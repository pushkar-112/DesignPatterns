package DesignPatterns;

// DesignPatterns.Factory Pattern
// Creation Design Pattern
// Delegates object creation to a separate class
// Example: Payment System

// Requirements:
// Multiple type of payments - Card, UPI, Wallet

public class FactoryAndStrategy {

    public static void main(String[] args){
        System.out.println("Hello");

        PaymentFactory1 paymentFactory =  new PaymentFactory1();
        PaymentStrategy1 strategy = paymentFactory.getPaymentStrategy("UPI");

        // Use strategy via Context
        PaymentContext1 context = new PaymentContext1(strategy);
        context.executePayment();

        // Change strategy at runtime
        context.setStrategy(paymentFactory.getPaymentStrategy("CARD"));
        context.executePayment();
    }
}

class PaymentContext1 {

    private PaymentStrategy1 strategy;

    public PaymentContext1(PaymentStrategy1 strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy1 strategy) {
        this.strategy = strategy;
    }

    public void executePayment() {
        strategy.pay();
    }
}

class PaymentFactory1 {

    PaymentStrategy1 getPaymentStrategy(String type){

        if ("CARD".equals(type)){
            return new CardPayment1();
        }
        if ("UPI".equals(type)){
            return new UPIPayment1();
        }

        throw new IllegalArgumentException("Invalid Type");
    }
}

interface PaymentStrategy1 {
    void pay();
}

class CardPayment1 implements PaymentStrategy1{
    @Override
    public void pay(){
        System.out.println("Card Payment");
    }
}

class UPIPayment1 implements PaymentStrategy1{
    @Override
    public void pay(){
        System.out.println("UPI Payment");
    }
}

