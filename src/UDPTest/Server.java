package UDPTest;

import javaExerciseSheet3.Restaurant;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {

        System.out.println("Server gestartet");

        try {
            DatagramSocket serverSocket = new DatagramSocket(7071);
            while (true) {

                byte[] buffer = new byte[100];
                DatagramPacket received_packet = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(received_packet);
                System.out.println("Empfangende Nachricht: " + new String(received_packet.getData()));

                DatagramPacket reply = new DatagramPacket(received_packet.getData(), received_packet.getLength(), received_packet.getAddress(), received_packet.getPort());
                System.out.println("Nachricht zurückgesendet zu: " + received_packet.getAddress() + ":" + received_packet.getPort());
                serverSocket.send(reply);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
