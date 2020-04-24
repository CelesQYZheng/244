import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;

public class BitLevel{
    public static void main(String[] args) throws Exception{
        // String[] args = {"3", "hello", "^*(^*^&*^&(*^"};
        FileInputStream fis = new FileInputStream(new File(args[0]));
        FileOutputStream outp = new FileOutputStream(new File(args[1]));
        // scaneer
        System.out.println("Enter the key");
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        //scan.close();
        // String key="";
        // while(scan.hasNext()){
        // key+=scan.next();
        // }
  
        int count = 0;
        // read the key as a string
        try{

            // while((input=InputStream.read())!=-1){
            while(true){
                int input = fis.read();
               
                if(input == -1){
                    break;
                }
                int k = key.charAt(count);
                
                outp.write(input ^ k);
                count++;
                if(count == key.length()){
                    count = 0;
                }
            }
            // System.in.close();
            //System.out.close();
        }catch(FileNotFoundException e){
            //    System.err.println("I/O error occurs");
            //}
        }
    }
}
    /*
int i = 5 = 0b0101; 
char c = 65;
char c = 'A'; // 0 - 255
*/
