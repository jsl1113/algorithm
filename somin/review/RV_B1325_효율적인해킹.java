package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B1325_효율적인해킹 {

	static int n,m;
	static ArrayList<Integer>[] list;
	static boolean[]isVisited;
	static int [] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n+1];
		cnt = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=0;i<=n;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
//		System.out.println(Arrays.toString(list));

		for(int i=1;i<=n;i++) {
			isVisited = new boolean[n+1];
			dfs(i);
		}
		
//		System.out.println(Arrays.toString(cnt));
		int max=0;
		for(int i:cnt) {
			if(max<i)max=i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
			if(cnt[i]==max) sb.append(i+" ");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int a) {
		isVisited[a]=true;
	
		for(int i : list[a]) {
			if(!isVisited[i]) {
				
				cnt[i]++;
				dfs(i);
				
			}
		}
	}

}
