import java.io.*;
import java.net.*;
 
class UDPServer
{
   public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(9860);
         BufferedReader inFromServer =new BufferedReader(new InputStreamReader(System.in));
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
           
            while(true)
               {

                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    //    System.out.println("Length "+ receiveData.length);
                  serverSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData(),0,receivePacket.getLength());
                  System.out.println("Client: " + sentence);
                  String msg = inFromServer.readLine();
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();

                //  String capitalizedSentence = msg.toUpperCase();
                  sendData = msg.getBytes();
                  DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket);
                              //receiveData=null;
               }
      }
}
