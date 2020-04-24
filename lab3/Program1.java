import java.io.IOException;

public class Program1{
    public static void main(String[] args){
       
        try{
            while(true) {
                int b = System.in.read();
                System.out.write(b);
                if(b == -1) break;
                System.out.flush();
               
            }
        }catch(IOException e){
            System.err.println("I/O error occurs");
        }

    }
}
