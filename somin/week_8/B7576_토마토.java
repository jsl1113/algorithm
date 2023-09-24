package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576_�丶�� {

	static int n,m;
	static int[][] tomato;
	static boolean[][] isVisited;
	static int ans = 0;
	//���� �丶���� ��ǥ : one
	static ArrayList<int []> one = new ArrayList<int[]>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tomato = new int[m][n];
		isVisited = new boolean [m][n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				 
				if(tomato[i][j]==1) one.add(new int[] {i,j});
			}
		}
//		System.out.println(Arrays.deepToString(tomato));
		
		bfs();
		
		boolean ripe = true;
		for(int[] q: tomato) {
			for(int r: q) {
				if(r==0) { //�� ���� �丶�䰡 �ִٸ�
					ripe = false;
					break;
				}
			}
		}
		
		if(ripe) System.out.println(ans-1);
		else
			System.out.println(-1);

	}
	
	public static void bfs() {
		Queue<int []> queue = new LinkedList<int[]>();
		
		for(int[] node: one) {
			queue.add(node);
			isVisited[node[0]][node[1]] = true;
		}
		
		//cnt = �� �� ���Ͽ� ���� �丶���� ����
		int cnt = one.size();
		//sum = ���� �丶�� �ֺ��� �ִ� ���� �丶���� �� ����
		int sum=0;
		
		while(!queue.isEmpty()) {
			int [] now = queue.poll();
			
			int [] dx = {-1,1,0,0};
			int [] dy = {0,0,-1,1};
			int ck=0;
			
			for(int k=0;k<4;k++) {
				int nx = now[0]+dx[k];
				int ny = now[1]+dy[k];
				
		
				if(nx>=0 && ny>=0 && nx<m && ny<n 
						&& !isVisited[nx][ny]
						&& tomato[nx][ny]==0) {
					
					isVisited[nx][ny] = true;
					tomato[nx][ny] = 1;
					queue.add(new int[] {nx,ny});
					ck++; 					
					
				}
			}

			//ck�� now��ǥ �ֺ� �丶��(0:������ �丶��) �����̴�.
			sum+=ck;
			//now �丶�� �ֺ������ �������Ƿ� now�丶�� ����
			cnt--;			
			//cnt�� 0�� �Ǹ� �Ϸ簡 �����ٴ� �� 
			if(cnt == 0) {
				//sum�� ���� �丶��� ���� �� ������ ���� �丶���� �����̴�.
				cnt = sum;
				sum=0;
				ans++;
			}
			
		}
		
		
		
	}

}
