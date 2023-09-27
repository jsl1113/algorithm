package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B15654_N°úM5 {

	static int n,m;
	static int[] arr;
	static boolean [] isVisited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		isVisited = new boolean [n];
		
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
	}
	
	public static void dfs(int cnt) {
		
		if(cnt ==m) {
			
			for(int i: al) System.out.print(i+" ");
			System.out.println();
			
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				al.add(arr[i]);
				dfs(cnt+1 );
				isVisited[i] = false;
				al.remove(al.size()-1);
				
			}
		}
		
		
	}

}
