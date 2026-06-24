package DesignPatterns;

// Structural Pattern
    // Helps add dynamic behavior
    // Avoid multiple concrete class and duplicate logic

// Implementation
    //


import javax.lang.model.util.SimpleElementVisitor6;

public class Decorator {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.cost());

    }
}

interface Coffee{
    int cost();
}



class SimpleCoffee implements Coffee {

    public int cost() {
        return 20;
    }
}

abstract class CoffeeDecorator implements Coffee{
    Coffee coffee;

    CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}


class MilkDecorator extends CoffeeDecorator{
    MilkDecorator(Coffee coffee){
        super(coffee);
    }
    public int cost(){
        return coffee.cost() + 15;
    }
}

class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee){
       super(coffee);
    }
    public int cost(){
        return coffee.cost() + 10;
    }
}

