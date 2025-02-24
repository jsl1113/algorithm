import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 10의 몇제곱이 있는지를 알아내면 된다.
 * 2 * 5가 몇개인지 알면 된다.
 * 2의제곱보다 5의 제곱이 더 적을 수 밖에 없다.
 * 5의 제곱이 몇개 있는지 알아내는 것이 곧 답.
 */
public class B1676_팩토리얼0의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		if(n==0 || n==1) {
			System.out.println(0);
			return;
		}
		int ans=0;
		for(int i=n;i>=1;i--) {
			if(i%5==0) {
				int cnt = nPow(i, 5);
				ans+=cnt;
			}
		}
		System.out.println(ans);
		
	}
	
	static int nPow(int x, int n) {
		// x가 n의 몇제곱 포함인지
		// 400이 5의 몇제곱 있는지 . 5*5*5
		int cnt=0;
		while(x%n==0 && x>0 ) {
			x /= n;
			cnt++;
		}
		return cnt;
	}
	

}
