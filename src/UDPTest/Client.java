package UDPTest;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket(7070);

            Scanner s = new Scanner(System.in);
            InetAddress address = InetAddress.getByName("localhost");
            System.out.println("Client Address: " + address);
            while (true) {
                String input = s.nextLine();
                byte[] message = input.getBytes();


                DatagramPacket message_client = new DatagramPacket(message, message.length, address, 7071);
                clientSocket.send(message_client);

                byte[] buffer = new byte[100];
                DatagramPacket reply_server = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(reply_server);
                System.out.println("Antwort Server: " + new String(reply_server.getData()));
            }
           // clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
