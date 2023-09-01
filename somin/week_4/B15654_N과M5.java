/*
 * N과 M 왜 어렵냐
 * N과 M (1)을 복습하고 푸니까 바로 풀린다......현타오네
 */
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class B15654_N과M5 {

	static int n,m;
	static ArrayList<Integer> ans= new ArrayList<Integer>();
	static ArrayList<Integer> a =new ArrayList<Integer>();
	static boolean [] isVisited;

	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n];
	
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(a);
		
		name(0);
	}
	
	public static void name(int cnt) {
		if(cnt==m) {
			for(int i:ans) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				ans.add(a.get(i));
				name(cnt+1);
				isVisited[i] = false;
				ans.remove(Integer.valueOf(a.get(i)));
			}
		}
	}

}
