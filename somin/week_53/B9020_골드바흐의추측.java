import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9020_골드바흐의추측 {

	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			solve(n);
		}
	}
	 
	static void solve(int n) {
		//10000보다 작거나 같은 모든 짝수에 대해 
		//두 소수의 합으로 나타내기 (두 수의 차이가 가장 적도록)
		// n/2 부터 
		
		for(int i=n/2;i>=2;i--) {
			if(isPrime(i)&& isPrime(n-i)) {
				System.out.println(i+" "+(n-i));
				break;
			}
		}
	}
	
	static boolean isPrime(int n ) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
		
	}

}
