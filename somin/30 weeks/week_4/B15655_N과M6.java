/*
 * N과 M 왜 어렵냐
 * 그래도 해냈다 이제 중복 X 와 중복가능의 차이를 좀 안 것 같음
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

public class B15655_N과M6 {

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
		
		name(0,0);
	}
	
	public static void name(int cnt, int start) {
		
		if(cnt == m) {
			for(int i=0;i<n;i++) {
				if(isVisited[i]) {
					System.out.print(a.get(i)+" ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				name(cnt+1,i+1);
				isVisited[i] = false;
				
			}
		}

	}

}
