/*
 * 해결 못한 이유
 * arr[n][m] 의 배열을 만들어서 아래의 모양을 어떻게 답으로 출력할까 고민했다.
 * n=3 m=2 
 * 00
 * 00
 * 00 
 * 
 * 해결방법 : 재귀
 * 기존의 방식에서 isVisited[] 방문여부를 체크 안하면 된다.
 * m의 길이의 배열을 만들고 ( m = 3 => [0, 0 ,0])
 *  [1, 1, 1 ] 3번 깊이 들어오면 출력하기하고 나가기
 *  [1, 1, 2 ] 1의 다음숫자인 2가 들어오고  ~~
 *  정말 간단한 방법이였다. 왜 생각못했지.. 
 *  너무 DFS로 풀어야겠다는 생각때문에 그런 것 같다 
 *  재귀로 푸는 문제였다.
 *  
 *  StringBuilder를 사용하자 - 시간초과를 없애준다!
 */
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15651_N과M3 {

	static int n,m;
	static int [] arr;
	static StringBuilder s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		s = new StringBuilder();
		dfs(0);
		System.out.print(s);

	}
	
	public static void dfs(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				s.append(arr[i]+" ");
			}
			s.append("\n");
			return;
		}
		//순열 (순서가 다르면 다른 것) 
		for(int i=0;i<n;i++) {
			arr[cnt] = i+1;
			dfs(cnt+1);
		}
	}

}
