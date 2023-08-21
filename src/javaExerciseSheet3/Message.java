package javaExerciseSheet3;

import java.io.*;
import java.util.ArrayList;

public class Message implements Serializable {

    int method;     //1=AddDish 2=getDishNames 0=requestRestaurants
    int restaurant; // 1= restaurant1 2= restaurant2

    //addDish
    String dishName;
    int dishNutritionValue;
    double dishPrice;

    //getDishes names
    ArrayList<String> dishNames_OR_serverRestaurants;

    Message() {
    }

    //Everything
    Message(int method, int restaurant, String dishName, int dishNutritionValue, double dishPrice, ArrayList<String> dishNames_OR_serverRestaurants) {
        this.method = method;
        this.restaurant = restaurant;
        this.dishName = dishName;
        this.dishNutritionValue = dishNutritionValue;
        this.dishPrice = dishPrice;
        this.dishNames_OR_serverRestaurants = dishNames_OR_serverRestaurants;
    }


    //--------------------------Constructor for      Client -> Server--------------------------

    //getRestaurants
    Message(int method) {
        this(method, 0, null, 0, 0.0, null);
    }

    //addDish
    Message(int method, int restaurant, String dishName, int dishNutritionValue, double dishPrice) {
        this(method, restaurant, dishName, dishNutritionValue, dishPrice, null);
    }

    //getALlDishNames
    Message(int method, int restaurant) {
        this(method, restaurant, null, 0, 0.0, null);
    }

    //--------------------------Constructor for      Server -> Client--------------------------

    //ReturnRestaurants
    Message(int method, ArrayList<String> restaurantsNames) {
        this(method, 0, null, 0, 0.0, restaurantsNames);
    }

    //return addDish acknowledgement
    Message(int method, int restaurant, String acknowledgement) {
        this(method, restaurant, acknowledgement, 0, 0.0, null);
    }

    //returnAllDishNames
    Message(int method, int restaurant, ArrayList<String> dishes) {
        this(method, restaurant, null, 0, 0.0, dishes);
    }


    //Serialization & Deserialization
    public static byte[] serializeMessage(Message m) {
        //String fileLocation ="src\\javaExerciseSheet3\\client.ser";
        try {
            //FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(m);
            byte[] temp = byteOut.toByteArray();
            out.close();
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Message deserializeMessage(byte[] m) {
        try {
            ByteArrayInputStream byteIn = new ByteArrayInputStream(m);
            ObjectInputStream in = new ObjectInputStream(byteIn);
            Message message = (Message) in.readObject();

            in.close();
            return message;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
