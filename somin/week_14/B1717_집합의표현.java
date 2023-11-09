package BOJ.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1717_집합의표현 {

	static int n,m;
	static int[] node;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		node = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			node[i] =i;
		}
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(q == 0) {
				union(a, b);
			}else {
				if(isUnion(a, b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
			
			
		}
		
	
		
	}
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A!=B) node[B] = A; 
	}
	
	public static boolean isUnion(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A!=B)return false;
		else
			return true;
	}
	public static int find(int a) {
		if(node[a]==a) {
			return a;
		}
		return node[a] = find(node[a]);
	}

}
