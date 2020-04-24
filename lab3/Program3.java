import java.util.Scanner;
import java.io.IOException;
 

public class Program3{
    public static String upperCase(String s){
        for(int i = 0; i < s.length();i++){
            s = s.toUpperCase();
        }
        return s;
    }
        
    public static void main(String[] args){
        String inputstr = "";
        
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
                inputstr += scan.nextLine();
            }

        System.out.println(upperCase(inputstr));
    }
}
