import java.io.*;
import java.net.*;
import java.util.*;
public class AnotherTCP{
    private PrintWriter output;
    private BufferedReader input;
    public AnotherTCP(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void startReceiving() throws Exception {
        String line;
        
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            // send dateTime.string.thing to the socket's output
            Date d = new Date();
            //long t = d.getTime();
            //int dt = d.getDate();
            //String s = "Received at date: "+dt +" time:"+ t;
            output.println(d.toString());
        }
    }
    
    public void startSending() throws Exception{

        Scanner stdin = new Scanner(System.in);
        System.err.println("Please enter data here");
        while (stdin.hasNextLine()) {
            output.println(stdin.nextLine());
            // receive the dateTime.stringthing from input
            System.out.println(input.readLine());   
        }
       
    
    }
    public static void main(String[] args) {
        Socket socket = null;
        try {
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                socket = new Socket(args[1], port);
                System.err.println("Connected to " + args[1] + " on port " + port);
                AnotherTCP example = new AnotherTCP(socket);
                example.startSending();
            } else {
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                AnotherTCP example = new AnotherTCP(socket);
                example.startReceiving();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCPExample <port> [host]");
        }
    }
}
