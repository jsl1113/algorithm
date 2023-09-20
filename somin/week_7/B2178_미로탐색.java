package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//너비 우선탐색 : bfs ?
/*
 * 어떻게 큐를 활용해야하지.. 했다.
 * 그리고 조건을 두고 하는 법도 몰랐다..
 * Queue<int []> que 큐의 자료형도 int [] 가능한지 몰랐고
 * 추가할 때 que.add(new int[] {i,j}); 이렇게 해준다.
 * graph에다가 횟수를 더하는 방식으로 계산했다.
 * 상하좌우 계산할 때 만약 범위안에 없는 경우는 (next_x<0 || next_x>=n || next_y<0 || next_y>=m ) 이렇게
 * 
 * 결론 : 연습이 더 필요하군.
 */
public class B2178_미로탐색 {

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int n,m;
	static int [][] graph;
//	static int [][] ans;
	static boolean [][] isVisited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		//ans = new int[n][m];
		isVisited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String[] s = bf.readLine().split("");
//			String line = bf.readLine();
			for(int j=0;j<m;j++) {
				graph[i][j] = Integer.parseInt(s[j]);
//				graph[i][j] = line.charAt(j) - '0';
				
			}
		}
		
		
		bfs(0,0);
//		System.out.println(Arrays.deepToString(graph));

		System.out.println(graph[n-1][m-1]);
	}

	static void bfs(int i,int j) {
		Queue<int []> que = new ArrayDeque<>();
		que.add(new int[] {i,j});
		isVisited[i][j] = true;
		while(!que.isEmpty()) {
			int [] now = que.poll();
			for(int k=0;k<4;k++) {
				
				//다음 좌표 계산 (상하좌우)
				int next_x = now[0]+dx[k];
				int next_y = now[1]+dy[k];
				
				// 해당 좌표로 움직이지 못하는 경우, 좌표가 유효하지 않거나(0) ,  이미 방문한 좌표일 경우 넘어간다.
				if((next_x<0 || next_x>=n || next_y<0 || next_y>=m ) //이 조건이 무조건 첫번째 조건이여야 함.
						||graph[next_x][next_y]==0 
						|| isVisited[next_x][next_y]) continue;
				
				isVisited[next_x][next_y] = true;
				graph[next_x][next_y] = graph[now[0]][now[1]]+1;
				que.add(new int[] {next_x,next_y});
//				for(int[] a:graph) {
//					for(int b:a) {
//						System.out.print(b+" ");
//					}System.out.println();
//				}
//				System.out.println("---------");
			}
		}

	}
	


}
