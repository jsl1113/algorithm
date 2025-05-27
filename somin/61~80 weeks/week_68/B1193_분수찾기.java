import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1193_분수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x =Integer.parseInt(br.readLine());
		
		int sum=0;
		int r=0,c=0,n=0;
		int minus = 0;
		for(int i=1;i<10000000;i++) {
			sum +=i;
			if(x<=sum) {
				n = i-1;
				minus=(sum-x);
				break;
			}
			
		}
		
		r = n-minus;
		c = minus;
		
		//n이 홀수면 반대다
		if(n!=1 && n%2==0) {
			System.out.println((c+1)+"/"+(r+1));
			
		}else {
			System.out.println((r+1)+"/"+(c+1));
		}
		
		
	}

}
