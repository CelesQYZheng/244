
public class Count{
    
    public int word(String s){
        int x = s.length();
        int num = 0;
        for(int i = 0; i < x; i++){

            if(s.charAt(i)==" "){
                num++;
            }else{

            }
        }
        return num;
    }
    public String change(String s){
        String new = s.toLowerCase();
        return new;
    }
}
     
