import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2023_신기한소수 {

	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(2);
			System.out.println(3);
			System.out.println(5);
			System.out.println(7);
			return;
		}
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<n-1;i++) {
			ArrayList<Integer> nlst = new ArrayList<Integer>();
			if(i==0) {
				lst.add(2);
				lst.add(3);
				lst.add(5);
				lst.add(7);
			}
			for(int nn : lst) {
				nlst = sol(nn , nlst);
			}
			lst = nlst;
		}
		
		Collections.sort(lst);
		StringBuffer sf = new StringBuffer();
		for(int nn : lst ) {
			sf.append(nn+"\n");
		}
		System.out.println(sf);
	}
	
	// 소수인지 판별을 어떻게 해? 1과 자기자신만 약수로 가지고 있는 수.
	static ArrayList<Integer> sol(int num, ArrayList<Integer> nlst) {
		
		for(int i=0;i<=9;i++) {
			int now = num*10+i;
			if(isPrime(now)) {
				nlst.add(now);
			}
		}
		
		return nlst;
	}
	
	static boolean isPrime(int num) {
				
		for(int i=2;i<= Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
}
