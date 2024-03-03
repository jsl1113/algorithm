import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
//		long ans = (long) Math.pow(a, b);
//		ans %=c;
		
		System.out.println(pow(a, b, c));
		
//		pow(a, b, c);
	}
	/*
	 * 지수법칙 + 모듈러 성질
	 * a^(n+m) = a^n * a^m
	 * 
	 * (a*b)mod C = (a mod C * b mod C) mod C
	 */
	static long pow(long a,long b, long c) {
		
		//지수가 1이면 a의 1제곱 = a 자체이기 때문
		if(b==1) {
			return a%c;
		}
		
		long tmp = pow(a,b/2,c);
		
		/*
		 * 현재 지수가 홀수라면
		 * a^(b/2) * a^(b/2) * a 
		 *                    하나 
		 */
		if(b%2==1) {
			return (tmp * tmp%c) * a%c;
		}
		
		return tmp * tmp %c;
	}

}
