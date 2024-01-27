package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// long 타입 이슈 ㅜ
public class B13305_주유소 {

	static int n;
	static int [] dist, cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		dist = new int[n-1];
		cost = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n-1;i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.toString(dist));
		
		long answer =0;
		
		long pre = cost[0];
		

		
		for(int i=0;i<n-1;i++) {

			if(pre > cost[i]) pre = cost[i];
			answer += pre * dist[i];
			
		}
		
		System.out.println(answer);
		
	}

}
