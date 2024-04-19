import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B13023_ABCDE {

	static int n,m;
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	static int ans =0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		arr = new ArrayList[n];
		for(int i=0;i<n;i++) arr[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			visit = new boolean[n];
			dfs(0, 0);
			if(ans==1) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
		
	}
	
	
	static void dfs(int now, int cnt) {
		
		if(cnt == 4) {
//			System.out.println("yes");
			ans = 1;
			return;
		}
		
		visit[now] = true;
		
		for(int node : arr[now]) {
			if(!visit[node]) {
				dfs(node,cnt+1);
			}
			
		}
		visit[now] = false;
		
	}
	
}
