package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * nCr = n!/ (n-r)! r!
 * 100!은 long으로도 불가능하다 더 큰 빅인티저를 사용해야한다. 이래서 정답율이 낮았군.
 * BigInteger!!!!!!!
 * 그리고 이건 곱셈, 나눗셈을 a.multiply(b) / a.divide(b) 로 표현해야 한다
 */
public class B2407_조합 {

	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if(n==m) {
			System.out.println(1);
			return;
		}
		
		BigInteger up =BigInteger.ONE;
		BigInteger down =BigInteger.ONE;
		
		for(int i=n;i>=n-m+1;i--) {
			up = up.multiply(new BigInteger(String.valueOf(i)));
		}

		for(int i=1;i<=m;i++) {
			down = down.multiply(new BigInteger(String.valueOf(i)));
		}
		BigInteger ans = up.divide(down);
		System.out.println(ans);
	
	}
	
}
