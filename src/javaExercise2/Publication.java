package javaExercise2;

public class Publication implements Display{
    private String title;
    private String language;
    private double price;

    Publication(String title, String language, double price){
        this.title = title;
        this.language = language;
        this.price = price;
    }
    Publication(){

    }

    public void print(){
        System.out.println("Title: "+title);
        System.out.println("Language: "+language);
        System.out.println("Price: "+price);


    }



}
