import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1416_도서관 {

	static int n,m;
	static ArrayList<Integer> minus = new ArrayList<Integer>();
	static ArrayList<Integer> plus = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			max = Math.max(max , Math.abs(num));
			if(num<0) {
				minus.add(num);
			}else
				plus.add(num);
		}
		
		Collections.sort(minus);
		Collections.sort(plus);
		
		int ans = 0;
		ans = solveMinus() + solvePlus();
		ans -= max;
		System.out.println(ans);
	}
	
	static int solveMinus() {
		
		//0을 기준으로 음수 시작
		int ans = 0;
		while(!minus.isEmpty()) {
			int dist = minus.get(0);
			for(int i=0;i<m;i++) {
				minus.remove(0);
				if(minus.isEmpty()) {
					break;
				}
			}
			ans += (dist*2);
		}
		return Math.abs(ans);
	}
	static int solvePlus() {
		//0을 기준으로 양수 시작
		int ans2 = 0;
		Collections.sort(plus,Collections.reverseOrder());
		while(!plus.isEmpty()) {
			int dist = plus.get(0);
			for(int i=0;i<m;i++) {
				plus.remove(0);
				if(plus.isEmpty()) {
					break;
				}
			}
			ans2 += (dist*2);
		}
		return ans2;
	}

}
