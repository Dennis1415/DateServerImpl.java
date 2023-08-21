package javaExercise2;

public class Car implements Display {
    private String colour;
    private int horsepower;
    private double weight;

    Car(){
        this.colour="Null";
        this.horsepower=0;
        this.weight = 0.0;
    }
    Car(String colour, int horsepower, double weight){
        this.colour=colour;
        this.horsepower=horsepower;
        this.weight = weight;
    }

    public void print(){

        System.out.println("Colour: "+this.colour);
        System.out.println("Horsepower: "+this.horsepower);
        System.out.println("Weight: "+this.weight);
    }

}
