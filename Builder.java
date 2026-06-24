package DesignPatterns;

// Builder Design Pattern
    // Creational Design Pattern
    // Step-by-Step Approach to create complex objects
    // No large number of parameters to constructors, No sequence errors

// Implementation
    // Private constructor with builder object parameter and set parameters from builder
    // Static builder sub-class with setter methods and build() method calling private constructor
    // Chained method calling in main using builder.

public class Builder {

    public static void main(String args[]){

        System.out.println("Hello World");

        User user = new User.Builder()
                .setName("Alan")
                .setAge(20)
                .setCity("Mumbai")
                .build();

        System.out.println(" User Created: "+user.toString());


    }
}


class User{

    // private variables
    private String name;
    private int age;
    private String city;

    // Private constructor
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    // static builder sub-class
    static class Builder{

        private String name;
        private int age;
        private String city;

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setAge(int age) {
            this.age = age;
            return this;
        }

        Builder setCity(String city) {
            this.city = city;
            return this;
        }

        User build(){
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age +
                ", city='" + city + "}";
    }
}