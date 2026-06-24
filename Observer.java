package DesignPatterns;

// Behavioral Design Pattern
    // Subject and Observers -- in a one-many relationship
    // When subject's state changes --> all observers are notified/updated automatically
// Real world -->  Used in Kafka consumers, pub-sub systems, event-driven architectures
// Example --> Order Service
    //When an order is placed, you might need to:
        // Send notification
        // Update inventory
        // Trigger billing

// Implementation
    //1. Subject Class (OrderService)
        // List of all observers --> generic List<Observers> observers = new ArrayList<>();
        // Methods to add/remove observer --> generic addObserver(), removeObserver()
        // Method to notify all observers --> generic notifyObservers() --> contains call to update()
        // call to update all observer on an event (event = order placed)
    //2. All Observers implement the update() method as event handler
    //3. Add all order Observers in main/configuration


import java.util.ArrayList;
import java.util.List;

public class Observer {

    public static void main(String[] args){

        System.out.println("Hello World");

        OrderService orderService =  new OrderService();

        // Register observers
        orderService.addObserver(new InventoryService());
        orderService.addObserver(new BillingService());
        orderService.addObserver(new NotificationService());

        orderService.placeOrder("ORDER123");

    }
}

//Observer Interface
interface OrderObserver {
    void update(String orderId);
}

// concrete subject class
class OrderService{

    private List<OrderObserver> observers =  new ArrayList<>();

    void addObserver(OrderObserver orderObserver){
        observers.add(orderObserver);
    }

    // to allow unsubscription
    void removeObserver(OrderObserver observer){
        observers.remove(observer);
    }

    void placeOrder(String orderId){
        System.out.println("Order Placed: "+orderId);

        // Notify all subscribers
        notifyObservers(orderId);
    }

    void notifyObservers(String orderId){
        for (OrderObserver observer : observers) {
            observer.update(orderId);
        }
    }

}

// concrete observer class
class InventoryService implements OrderObserver {

    // event handler
    public void update(String orderId){
        updateInventory(orderId);
    }

    // business logic
    public void updateInventory(String orderId){
        System.out.println("Update inventory for order: "+orderId);
    }
}

// concrete observer class
class BillingService implements OrderObserver{

    // event handler
    public void update(String orderId){
        generateBill(orderId);
    }

    // business logic
    public void generateBill(String orderId){
        System.out.println("Generated bill for order: "+orderId);
    }
}


// concrete observer class
class NotificationService implements OrderObserver{

    @Override
    public void update(String orderId){
        System.out.println("Notification for order "+orderId);
    }
}
