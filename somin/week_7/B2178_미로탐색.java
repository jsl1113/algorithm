package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//�ʺ� �켱Ž�� : bfs ?
/*
 * ��� ť�� Ȱ���ؾ�����.. �ߴ�.
 * �׸��� ������ �ΰ� �ϴ� ���� ������..
 * Queue<int []> que ť�� �ڷ����� int [] �������� ������
 * �߰��� �� que.add(new int[] {i,j}); �̷��� ���ش�.
 * graph���ٰ� Ƚ���� ���ϴ� ������� ����ߴ�.
 * �����¿� ����� �� ���� �����ȿ� ���� ���� (next_x<0 || next_x>=n || next_y<0 || next_y>=m ) �̷���
 * 
 * ��� : ������ �� �ʿ��ϱ�.
 */
public class B2178_�̷�Ž�� {

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
				
				//���� ��ǥ ��� (�����¿�)
				int next_x = now[0]+dx[k];
				int next_y = now[1]+dy[k];
				
				// �ش� ��ǥ�� �������� ���ϴ� ���, ��ǥ�� ��ȿ���� �ʰų�(0) ,  �̹� �湮�� ��ǥ�� ��� �Ѿ��.
				if((next_x<0 || next_x>=n || next_y<0 || next_y>=m ) //�� ������ ������ ù��° �����̿��� ��.
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
