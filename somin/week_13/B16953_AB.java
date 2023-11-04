package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16953_AB {

	static int a,b;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		change(b, 1);
		System.out.println(ans);
	}
	
	public static void change(int number, int cnt) {
		if(number == a) {
			ans = Math.min(ans, cnt);
			return;
		}
		else if(number<a) {
			ans = -1;
			return;
		}
		
		else if(number%2==0) {
			number = number/2;
			change(number, cnt+1);
		}
		
		//1로 끝날때
		else if(number%10==1) {
			number = number/10;
			change(number, cnt+1);
		}
		else{
			ans = -1;
			return;
		}
	}

}
