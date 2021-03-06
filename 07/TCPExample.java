import java.io.*;
import java.net.*;
import java.util.*;
public class TCPExample {
    private PrintWriter output;
    private BufferedReader input;
    /*passed a Socket*/
    public TCPExample(Socket socket) throws Exception {
        //sets output to be a socket output stream with a PrintWriter wrapped around it;
        output = new PrintWriter(socket.getOutputStream(), true);
        //sets input to be a socket input stream with a BufferedReader wrapped around it
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void startReceiving() throws Exception {
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            // send dateTime.string.thing to the socket's output
            //
        }
    }
    public void startSending() {
        Scanner stdin = new Scanner(System.in);
        System.err.println("Please enter data here");
        while (stdin.hasNextLine()) {
            output.println(stdin.nextLine());
            // receive the dateTime.stringthing from input
            //
        }
    }
    public static void main(String[] args) {
        //decares a variable called socket to be an instance of Socket;
        Socket socket = null;
        try {
            //initialises port to the first command line parameter;
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                //declares socket to be a Socket connected to the host at
                //the IP name and port number specified on the command line.
                socket = new Socket(args[1], port);

                //outputs text stating the host name and port connected to;
                System.err.println("Connected to " + args[1] + " on port " + port);

                //creates an instance of the TCPExample class called example;
                TCPExample example = new TCPExample(socket);
                example.startSending();
            } else {
                //declares serverSocket to be an instance ServerSocket attached to
                //the port number entered on the command line
                ServerSocket serverSocket = new ServerSocket(port);
                
                //outputs a message that the receiver is waiting for someone to connect to it.
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();//calls the accept() method
                
                //prints a message that it accepted a connection on the port
                System.err.println("Accepted connection on port " + port);
                
                //creates an instance of the TCPExample class called example
                TCPExample example = new TCPExample(socket);
                example.startReceiving();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCPExample <port> [host]");
        }
    }
}
