import java.io.*;

public class ReadWriteThread extends Thread {
    private BufferedReader input;
    private PrintWriter output;
    private String pre;
    public ReadWriteThread(InputStream input, OutputStream output,String pre) {
     
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintWriter(output, true);
        this.pre = pre;
    }
    public void run() {
        try {
            String line;
           
            while ((line = input.readLine()) != null) {
                output.print(pre);
                output.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
