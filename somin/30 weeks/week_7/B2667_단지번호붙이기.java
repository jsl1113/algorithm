package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//�ð� ���� �ɸ� ���� : ��Ÿ����. ;;;;; 
//static int [] dy = {-1,1,0,0}; ��� ����� ;;;;;; ��¯��;;;
public class B2667_������ȣ���̱� {

	static int n,cnt;
	static int [][] map;
	static int [][] ans;
	static boolean [][] isVisited;
	static int [] list;
	static ArrayList<Integer> ans2 = new ArrayList<Integer>();
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		map = new int [n][n];
		ans = new int [n][n];
		isVisited = new boolean[n][n];
		list = new int[n*n];
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		cnt=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!isVisited[i][j] && map[i][j]!=0) {
					bfs(i,j);			
					cnt++;
				}
			}
		}
//		System.out.println(Arrays.deepToString(ans));
		System.out.println(cnt-1);
		Collections.sort(ans2);
		for(int a:ans2) {
			System.out.println(a);
		}

	}
	public static void bfs(int i,int j) {
		int c=1;
		Queue<int []> que = new LinkedList<>();
		que.add(new int [] {i,j});
		isVisited[i][j] = true;
		ans[i][j] = cnt;

		while(!que.isEmpty()) {
			int [] now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
		
				//�� ������ ���� �Ѿ��
				//��ȿ�� ������ �ƴ� ���� / �̹� �湮�� ���� / 0�� ���
				if(	!checkValid(nx, ny) 
						|| map[nx][ny]==0 
						|| isVisited[nx][ny]) continue;
				
				ans[nx][ny] = cnt;
				isVisited[nx][ny] = true;
				que.add(new int[] { nx,ny});
				c++;
//				for(int[] a:ans) {
//				for(int b:a) {
//					System.out.print(b+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("---------");
			}
			
			
		}
		ans2.add(c);
	}
	public static boolean checkValid(int nx,int ny) {
		if(nx<0 || ny<0 || nx >=n || ny>=n) return false;
		else
			return true;
	}
	
	

}
