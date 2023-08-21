package javaExerciseSheet3;

public class Dish {

    private String name;
    private int nutritionalValue;
    private double price;

    //Getter
    public String getName() {
        return name;
    }
    public int getNutritionalValue(){
        return nutritionalValue;
    }
    public double getPrice(){
        return price;
    }
    //Setter
    public void setPrice(double price){
        this.price=price;
    }

    //Constructor
    Dish(){
        name="null";
        nutritionalValue=0;
        price=0.0;
    }
    Dish(String name, int nutritionalValue, double price){
        this.name = name;
        this.nutritionalValue = nutritionalValue;
        this.price=price;
    }



}