import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1254_펠린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(int i=0;i<s.length();i++){
            String split = s.substring(i);

            if(isP(split)){
                System.out.println(s.length()+i);
                break;
            }
        }

    }

    static boolean isP(String str){

        int len = str.length();

        for(int i=0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }

        return true;

    }
}
