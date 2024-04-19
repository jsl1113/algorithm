package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 * nCr = n!/ (n-r)! r!
 * 100!�� long���ε� �Ұ����ϴ� �� ū ����Ƽ���� ����ؾ��Ѵ�. �̷��� �������� ���ұ�.
 * BigInteger!!!!!!!
 * �׸��� �̰� ����, �������� a.multiply(b) / a.divide(b) �� ǥ���ؾ� �Ѵ�
 */
public class B2407_���� {

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
