import java.io.IOException;
import java.util.Scanner;
public class BitLevel{
    public static void main(String[] args){
        // scaneer
        System.out.println("Enter the key");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine(); // read the key as a string
        try{
            int input;
            while((input=System.in.read())!=-1){
            // while(true){
                //int input = System.in.read();
                //if(input == -1){
                //   break;
                //}
                int count = 0;
                int k = key.charAt(count);
                System.out.write(input ^ k);
                count++;
                    if(count == key.length()){
                        count = 0;
                    }
            }
        }catch(IOException e){
            System.err.println("I/O error occurs");
        }
    }
}
/*
int i = 5 = 0b0101; 
char c = 65;
char c = 'A'; // 0 - 255
*/
