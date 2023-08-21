package Lecture6SocketCode;
import java.net.*;
import java.io.*;

public class UDPClient{
  public static void main( String args[]){
  // args[0]: Message
  // args[1]: Server
    try {
    
      System.out.println(" Message:  " + args[0]); //command line argument
    
      DatagramSocket aSocket = new DatagramSocket();//socket for sending and receiving data
      byte [] m = args[0].getBytes();//udp only allows to send byte arrays (as a packet)
      InetAddress aHost = InetAddress.getByName(args[1]);
      //InetAddress bHost = InetAddress.getLocalHost();
      int serverPort = 6789; //server port identifies socket and process
      DatagramPacket request = new DatagramPacket (m, m.length,//packet creation with the byte array, length of message, host and server port
                                                   aHost, serverPort);
      aSocket.send (request);//sending of message/packet

      byte[] buffer = new byte[1000];//buffer to save the received message in
      DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
      aSocket.receive (reply); //receive incoming packet
      System.out.println(" Reply: " + new String(reply.getData()));
      aSocket.close();//close socket

    }catch (SocketException e){ System.out.println(" Socket: " + e.getMessage());
    }catch (IOException e){ System.out.println(" IO: " + e.getMessage());}
  }
} 
