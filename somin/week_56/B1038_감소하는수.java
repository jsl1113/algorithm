import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B1038_감소하는수 {

	static int n;
	static ArrayList<Long> lst = new ArrayList<Long>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		if(n<=10) {
			System.out.println(n);
			return;
		}
		
		for(int i=1;i<10;i++) {
			sol(i,1);
		}
		Collections.sort(lst);
		
		if(lst.size()<n) {
			System.out.println("-1");
			return;
		}
		System.out.println(lst.get(n-1));
	}
	
	static void sol(long num, int th) {
		if(th>10) {
			return;
		}
		lst.add(num);
		
		for(int i=0;i<num%10;i++) {
			sol(num*10+i, th+1);
		}
		
	}

}
