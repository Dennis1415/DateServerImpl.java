package javaExerciseSheet3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientRestaurant extends Message {
    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final int serverPort = 7777;

        try {
            DatagramSocket clientSocket = new DatagramSocket(7778);
            InetAddress address = InetAddress.getByName("localhost");

            int selectedRestaurant = -1;
            boolean running = true;

            while (running) {

                printActions();
                int input = scan.nextInt();

                switch (input) {
                    case 1: //Prints both restaurants from server
                        clientSocket.send(prepareDPtoSend(new Message(0), address, serverPort));
                        Message messageR = receiveMessage(clientSocket);
                        System.out.println( "Available restaurants are: \n" +
                                            "[1]" + messageR.dishNames_OR_serverRestaurants.get(0) + "\n" +
                                            "[2]" + messageR.dishNames_OR_serverRestaurants.get(1));
                        break;

                    case 2: //lets user select one of the two restaurants
                        System.out.println("Select a restaurant[1]/[2]: ");
                        int temp = scan.nextInt();
                        if (temp == 1 || temp == 2) {
                            selectedRestaurant = temp;
                            System.out.println("Selected restaurant: " + selectedRestaurant);
                        } else {
                            System.out.println("Wrong input");
                        }
                        break;

                    case 3: //lets user add a Dish in the previously selected restaurant
                        if (selectedRestaurant == -1) {
                            System.out.println("No restaurant selected !");
                            //break; lieber else oder n brake ?
                        } else {

                            //no space in between dish name
                            System.out.println("AddDish selected\nName of the new dish: ");
                            String nameDish = scan.next();
                            System.out.println("Nutrition Score: ");
                            int nutritionScore = scan.nextInt();
                            System.out.println("Price: ");
                            double priceDish = scan.nextDouble();

                            clientSocket.send(prepareDPtoSend(new Message(1, selectedRestaurant, nameDish, nutritionScore, priceDish), address, serverPort));
                            Message messageAdDish = receiveMessage(clientSocket);
                            System.out.println("Server message:" + messageAdDish.dishName);
                        }
                        break;

                    case 4: //prints all dishes of the previously selected restaurant
                        clientSocket.send(prepareDPtoSend(new Message(2, selectedRestaurant), address, serverPort));
                        Message messageRequestDishes = receiveMessage(clientSocket);
                        System.out.println("All dishes: ");
                        for (String s : messageRequestDishes.dishNames_OR_serverRestaurants) System.out.println(s);
                        break;

                    case 5: //terminates program
                        System.out.println("Program closed");
                        running = false;
                        break;

                    default: //back to the beginning
                        System.out.println("Wrong input. Try again");
                        break;

                }//switch
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main

    private static DatagramPacket prepareDPtoSend(Message m, InetAddress serverAddress, int serverPort) {
        byte[] request = serializeMessage(m);
        return new DatagramPacket(request, request.length, serverAddress, serverPort);
    }


    //Testen obs überhaupt Sinn macht!
    //Methoden lieber in MEssage Klasse  ?
    //_____________________________________________________________________________________________________\\
    private static Message receiveMessage(DatagramSocket socket) throws IOException {
        byte[] b = new byte[1000];
        DatagramPacket dp = new DatagramPacket(b, b.length);
        socket.receive(dp);
        return deserializeMessage(b);
    }

    private static void sendMessage(Message message, InetAddress serverAddress, int serverPort, DatagramSocket clientSocket) throws IOException {
        byte[] request = serializeMessage(message);
        DatagramPacket dp = new DatagramPacket(request, request.length, serverAddress, serverPort);
        clientSocket.send(dp);
    }
    //_____________________________________________________________________________________________________\\


    private static void printActions() {
        System.out.print("\nWhat action do you want to take ?\n"
                + "[1]Show available restaurants "
                + "[2]Select a restaurant "
                + "[3]Add a new dish  "
                + "[4]Show all available dishes   "
                + "[5]Exit program\n");
    }
}
/*
switch (input) {
        case 1:
        clientSocket.send(prepareDPtoSend(new Message(0), address, serverPort));

        byte[] testByte = new byte[1000];
        DatagramPacket testPacket = new DatagramPacket(testByte, testByte.length);
        clientSocket.receive(testPacket);
        Message testMessage = deserializeMessage(testByte);


        System.out.println("Available restaurants are: \n[1]" + testMessage.dishNames_OR_serverRestaurants.get(0) + "\n[2]" + testMessage.dishNames_OR_serverRestaurants.get(1));
        break;
        case 2:
        System.out.println("Select a restaurant(1/2): ");
        //scan 1 or 2 and safe in int
        Scanner s1 = new Scanner(System.in);
        selectedRestaurant = s1.nextInt();
        System.out.println("Selected restaurant: " + selectedRestaurant);
        break;
        case 3:
        Scanner s2 = new Scanner(System.in);

        System.out.println("AddDish selected\nName of the new dish: ");
        String nameDish = s2.next();
        System.out.println("Nutrition Score: ");
        int nutritionScore = s2.nextInt();
        System.out.println("Price: ");
        double priceDish = s2.nextDouble();
        clientSocket.send(prepareDPtoSend(new Message(1, selectedRestaurant, nameDish, nutritionScore, priceDish), address, serverPort));

        byte[] testByte2 = new byte[1000];
        DatagramPacket testPacket2 = new DatagramPacket(testByte2, testByte2.length);
        clientSocket.receive(testPacket2);
        Message testMessage2 = deserializeMessage(testByte2);
        System.out.println("Server message:" + testMessage2.dishName_OR_returnValue);
        break;
        case 4:
        clientSocket.send(prepareDPtoSend(new Message(2, selectedRestaurant), address, serverPort));

        byte[] testByte3 = new byte[1000];
        DatagramPacket testPacket3 = new DatagramPacket(testByte3, testByte3.length);
        clientSocket.receive(testPacket3);
        Message testMessage3 = deserializeMessage(testByte3);
        System.out.println("All dishes: ");
        //print ArrayList
        for (String s : testMessage3.dishNames_OR_serverRestaurants) System.out.println(s);
        break;
        case 5:
        System.out.println("Program closed");
        running = false;
        break;
default:
        System.out.println("Wrong input. Try again");
        //back to beginning
        break;
        }
        //switch
 */