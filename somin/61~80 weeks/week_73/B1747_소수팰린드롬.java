import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747_소수팰린드롬 {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            while(true){

                if(isPel(n)&&isPrime(n)){
                    System.out.println(n);
                    break;
                }
                n++;
            }
    }


    static boolean isPrime(int num){

        if(num == 1){
            return false;
        }
        //소수 판별을 위해 범위 지정하는 부분에서 틀렸습니다를 많이 봤다.
        // 왜 i < Math.sqrt(num)+1는 틀렸습니다로 나올까...
        for(int i =2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static boolean isPel(int num){
        String s = Integer.toString(num);
        int len = s.length();

        if(len ==1){
            return true;
        }

        for(int i=0;i<len/2;i++){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }

        return true;
    }

}
