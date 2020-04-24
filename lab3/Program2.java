import java.io.IOException;
import java.io.BufferedReader;
import java.lang.*;
import java.io.InputStreamReader;

public class Program2{
    public static void main(String[] args){
        String s ="";
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            while(true){
              
                s = rd.readLine();
                StringBuilder str= new StringBuilder(s);
                str.reverse();
                System.out.println(s);
            }
            
        }catch(IOException e){
            System.err.println("I/O error occurs");
        }

    }
}
