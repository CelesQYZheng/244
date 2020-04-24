import java.io.IOException;
public class Caesar{

    public static void main(String[] args){
        try{
            while(true){
                int input = System.in.read();
                if (input== -1){
                    break;
                }
                input = input + 3;

                if(input >255){
                    input = input - 256; //90% sure
                }
                //System.out.print("check");
                System.out.write(input);
            } 
        }catch(IOException e){
            System.err.println("I/O error occurs");
        }
    }
}

