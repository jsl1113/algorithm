package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1182_부분수열의합 {

	static int n,s,sum;
	static int check=0;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static boolean [] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean [n];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(arr);

		dfs(0);
		System.out.println(check);
	}
	// 부분집합의 합이 s가 될 경우
	public static void dfs(int cnt) {
		if(cnt == n) {
			sum=0;
			int vcnt=0;
			for(int i=0;i<n;i++) {
				if(isVisited[i]) {
					sum+= arr.get(i);
					vcnt++;
				}
			}
			//최소 부분집합의 원소가 하나이상이여야 한다.
			if(sum == s && vcnt>=1) {
				check++;
			}
			return;
		}

		//부분집합 구하는 알고리즘
		isVisited[cnt] = true;
		dfs(cnt+1);
		
		isVisited[cnt] = false;
		dfs(cnt+1);
	}

}
