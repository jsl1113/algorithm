package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 버튼누른 횟수 카운트를 하는 count[]를 만들 생각을 못했다.
 * 
 */
public class B5014_스타트링크 {

	static int F,S,G,U,D;
	static boolean[] isvisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		isvisited = new boolean[F+1];

		Bfs();
	}
	
	static void Bfs() {
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(S);
		isvisited[S] = true;
		
		int [] count = new int[F+1];
		count[S] = 0;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == G) {
				System.out.println(count[now]);
				return;
			}
			
			if( now+U<=F && U!=0) {
				if(!isvisited[now+U]) {
					isvisited[now+U] = true;
					que.add(now+U);
					count[now+U] = count[now]+1;
				}
			}
			
			if( now-D>=1 && D!=0) {
				if(!isvisited[now-D]) {
					isvisited[now-D] = true;
					que.add(now-D);
					count[now-D] = count[now]+1;
				}
			}
		}
		System.out.println("use the stairs");
		
	}
	

}
