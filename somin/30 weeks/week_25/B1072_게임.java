import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double x = Integer.parseInt(st.nextToken());
		double y = Integer.parseInt(st.nextToken());
		
//		System.out.println(x+","+y);
		
//		System.out.println(100*y/x);
		
		long first = (long) (( 100* ( double) y)/(double) x);
		long se = (long) (( 100* y)/ x);
		long z = (long) (100*y/x);
		
//		System.out.println(first);
		
		long s = 1;
		long e = 1000000000;
		
		boolean flag = false;
		
		//1. s<=e =을 넣어야하는지
		//2. e = mid-1; 왜 -1해줘야하는지 몰랐다.
		// 자료형을 왜 long으로 해야하지 
		while(s<=e) {
			
			long mid = (s+e)/2;
			
			long r = (long) (( 100* ( double) (y+mid))/(double) (x+mid));
			
			if(r>z) {
				e = mid-1;
				flag = true;
			}else {
				s = mid+1;
			}
			
		}
		System.out.println(s+" /"+e);
		if(flag)
			System.out.println(s);
		else
			System.out.println(-1);
	}
}
