package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2606_바이러스 {
	static int c,n;
	static ArrayList<Integer>[] computer;//= new ArrayList[c+1];
	static boolean [] isVisited;
	
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 
		c = Integer.parseInt(bf.readLine());
		n = Integer.parseInt(bf.readLine());
		
		computer = new ArrayList [c+1];
		for(int i=0;i<c+1;i++) computer[i] = new ArrayList<Integer>();
		isVisited = new boolean[c+1];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			computer[u].add(v);
			computer[v].add(u);
		}
//		System.out.println(Arrays.deepToString(computer));
		
		bfs(1);

		
		System.out.println(ans.size());
		
	}
	
	public static void bfs(int i) {
//		System.out.println(i+"번째");
//		for(boolean j:isVisited) System.out.print(j+" ");
//		System.out.println();

		for(int a: computer[i]) {
			if(i==1) isVisited[1] = true;
//			System.out.println("누구 "+a);
			if(!isVisited[a]) {
//				System.out.println(a+"번째 트루변경");
				isVisited[a] = true;
				ans.add(a);
				bfs(a);				
			}
		}
		
		
		
	}

}
