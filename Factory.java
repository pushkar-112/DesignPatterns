package DesignPatterns;

// DesignPatterns.Factory Pattern
// Creation Design Pattern
// Delegates object creation to a separate class
// Example: Payment System

// Requirements:
// Multiple type of payments - Card, UPI, Wallet

public class Factory {

    public static void main(String[] args){
        System.out.println("Hello");

        PaymentFactory paymentFactory =  new PaymentFactory();
        PaymentService payment = paymentFactory.getPayment("UPI");


        payment.pay();
    }
}


class PaymentFactory {

    PaymentService getPayment(String type){

        if("CARD".equalsIgnoreCase(type)){
            return new CardPayment();
        }
        if("UPI".equalsIgnoreCase(type)){
            return new UPIPayment();
        }

        throw new IllegalArgumentException("Invalid Type");
    }
}

interface PaymentService{
    void pay();
}

class CardPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Card Payment");
    }
}

class UPIPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("UPI Payment");
    }
}

