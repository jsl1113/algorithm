import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17626_FourSquares {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(isSquare(n)) {
            System.out.println(1);
            return;
        }

        for(int i=1; i*i<= n;i++) {
            if(isSquare(n - i*i)) {
                System.out.println(2);
                return;
            }
        }

        for(int i=1; i*i<= n;i++) {
            for(int j=i; j*j<= n - i*i;j++) {
                if(isSquare(n-i*i-j*j)) {
                    System.out.println(3);
                    return;
                }
            }
        }

        System.out.println(4);
    }

    private static boolean isSquare(int x) {
        if(x<0) 
        	return false;
        int num = (int) Math.sqrt(x);
        if(num*num == x) {
        	return true;
        }else
        	return false;
    }
}
