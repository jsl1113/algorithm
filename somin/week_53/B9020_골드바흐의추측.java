import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9020_������������ {

	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			solve(n);
		}
	}
	 
	static void solve(int n) {
		//10000���� �۰ų� ���� ��� ¦���� ���� 
		//�� �Ҽ��� ������ ��Ÿ���� (�� ���� ���̰� ���� ������)
		// n/2 ���� 
		
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
