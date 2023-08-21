package javaExerciseSheet3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

public class ServerRestaurant extends Message {
    public static Restaurant restaurant1 = new Restaurant("PizzaLuigi");
    public static Restaurant restaurant2 = new Restaurant("AsianRestaurant");

    public static void main(String[] args) {
        final int serverPort = 7777;

        System.out.println("Server started");

        restaurant1.initializeStandardDishes();
        restaurant2.initializeStandardDishes();

        try {
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            while (true) {

                byte[] buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(request);
                System.out.println("message received from: " + request.getAddress() + ":" + request.getPort());
                Message requestMessage = deserializeMessage(buffer);

                Message replyMessage = null;
                switch (requestMessage.method) {
                    case 0:
                        System.out.println("Restaurants requested...");
                        replyMessage = new Message(0, new ArrayList<String>(Arrays.asList(restaurant1.getRestaurantName(), restaurant2.getRestaurantName()))); //arrayList returnRestaurants
                        break;
                    case 1:
                        System.out.println("AddDishes Method");
                        if (requestMessage.restaurant == 1) {
                            restaurant1.addDish(requestMessage.dishName, requestMessage.dishNutritionValue, requestMessage.dishPrice);
                        } else {
                            restaurant2.addDish(requestMessage.dishName, requestMessage.dishNutritionValue, requestMessage.dishPrice);
                        }
                        //createMessage with acknowledgement string
                        replyMessage = new Message(1, requestMessage.restaurant, "Dish "+requestMessage.dishName+" added");
                        break;
                    case 2:
                        System.out.println("getAllDishNames Method");
                        replyMessage = new Message(2, requestMessage.restaurant, getAllDishNames(requestMessage.restaurant));
                        break;
                    default:
                        System.out.println("Error. Wrong Message");
                        //auch Message schicken ?
                        break;
                }
                byte[] replyByte = serializeMessage(replyMessage);
                DatagramPacket replyRest = new DatagramPacket(replyByte, replyByte.length, request.getAddress(), request.getPort()); //CLIENT OPTIONS
                serverSocket.send(replyRest);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getAllDishNames(int restaurant) {
        ArrayList<String> dishNames = new ArrayList<>();
        if (restaurant == 1) {
            for (Dish d : restaurant1.getDishes()) {
                dishNames.add(d.getName());
            }
        } else if (restaurant == 2) {
            for (Dish d : restaurant2.getDishes()) {
                dishNames.add(d.getName());
            }
        }
        return dishNames;
    }
}
