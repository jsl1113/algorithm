package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9372_상근이의여행 {

	static int n,m;
	static ArrayList<Integer>[] list;
	static boolean [] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			visit = new boolean[m];
			list = new ArrayList[n+1];
			for(int j=0;j<=n;j++) {
				list[j] = new ArrayList<Integer>();
			}
			
			for(int k=0;k<m;k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
				
			}
			System.out.println(n-1);
			
			
		}
	}
	
}
