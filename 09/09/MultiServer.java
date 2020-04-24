// MultiServer.java

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer extends Thread {
    //creates a LinkedList of PrintWriters called clients,keep track multiple clients.
    private static List<PrintWriter> clients = new LinkedList<PrintWriter>();

    public static void main(String[] args) {
        try {
            int port = Integer.parseInt(args[0]);
            ServerSocket serverSocket = new ServerSocket(port);
            //starts an instance of MultiServer. This
            // results in a call to the run() method
            new MultiServer().start();
            //a line so we know something happened when we started the server
            System.err.println("Waiting for a client to connect");
            //form an infinite while loop.
            while (true) {
                //calls the accept() method and waits for a client to connect.
                //The accept() method returns a Socket which is assigned to socket
                Socket socket = serverSocket.accept();
                //When a client connects, grant exclusive access to clients.
                synchronized(clients) {
                    //gets an OutputStream on the socket
                    //wraps a PrintWriter around it and adds it to the clients list
                    clients.add(new PrintWriter(socket.getOutputStream(), true));
                }
                //prints a message on the server screen about accepting a connection.
                System.err.println("Accepted connection on port " + port);
                //creates a new ReadWriteThread using the socket
                //for input and System.out for output, and starts the thread.
                new ReadWriteThread(socket.getInputStream(), System.out).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java MultiServer <port>");
        }
 
    }
 
    public void run() {
        //assigns stdin to a new Scanner for System.in
        Scanner stdin = new Scanner(System.in);
        //form a while loop which continues as long as
        //there is input to read from the keyboard.
        while (stdin.hasNextLine()) {
            //reads the line typed into the String variable line.
            String line = stdin.nextLine();
            //uses the synchronized keyword
            //It is applied to clients which is our list of clients.
            //What this does is give exclusive access to clients
            // access to clients.
            synchronized(clients) {
                //iterates through the list of clients. For each client,
                //we print the line which the Scanner read.
                //This results in line being sent to each client via their own socket
                for (PrintWriter client : clients) {
                    client.println(line);
                }
            }
        }
    }
}
