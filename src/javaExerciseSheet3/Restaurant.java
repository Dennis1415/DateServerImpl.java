package javaExerciseSheet3;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Dish> servedDishes = new ArrayList<Dish>();


    //1
    public Dish searchDish(String name) {
        for (Dish dish : servedDishes) {
            if (dish.getName().equals(name)) return dish;
        }
        System.out.println("No dish with name " + name + " found!!");
        return null;
    }

    //2
    public void addDish(String name, int nutritionalV, double price) {
        // Dish d = new Dish(name, nutritionalV, price);
        servedDishes.add(new Dish(name, nutritionalV, price));
    }

    //3
    public ArrayList<Dish> getDishes() {
        return servedDishes;
    }

    //4
    public String getRestaurantName() {
        return name;
    }

    //constructor

    Restaurant() {
        this("undefined");
        this.servedDishes = new ArrayList<Dish>();
    }

    Restaurant(String name) {
        this.name = name;
        this.servedDishes = new ArrayList<Dish>();
    }

    public void initializeStandardDishes(){
        this.addDish("Pizza-Salami", 900,6.99);
        this.addDish("Nudeln", 450,7.99);
        this.addDish("Osaft", 200,2.99);
        this.addDish("Cola",350,3.99);
        this.addDish("Bier",350,4.99);
    }

}
