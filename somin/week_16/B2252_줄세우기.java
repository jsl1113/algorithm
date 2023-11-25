package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int []d = new int[n+1];
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			d[b]++;
		}
		System.out.println(Arrays.toString(d));		
		System.out.println(Arrays.deepToString(list));
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1;i<n+1;i++) {
			if(d[i]==0) que.add(i);
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now+" ");
			
			for(int i=0;i<list[now].size();i++) {
				int nx = list[now].get(i);
				d[nx]--;
				if(d[nx]==0) que.add(nx);
			}
			
		}
		System.out.println(sb);
	}


}
