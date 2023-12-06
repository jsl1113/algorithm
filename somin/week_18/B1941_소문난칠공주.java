import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * bfs�����ϸ� �ð��ʰ�
 * 
 * 7���� ���� dfs
 * 7���� �پ������鼭 s�� 4���̻����� üũ bfs 
 */
public class B1941_�ҹ���ĥ���� {
	
	static int[][] map = new int[5][5];
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int ans=0;
	static int [] c = new int[7];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 for(int i=0;i<5;i++) {
			 String s = br.readLine();
			 for(int j=0;j<5;j++) {
				 if(s.charAt(j)== 'Y') map[i][j] = 0;
				 else {
					 map[i][j] = 1;
				 }
			 }
		 }
		 
		 System.out.println(Arrays.deepToString(map));
		
		 dfs(0,0,0);
		 System.out.println(ans);
		 
		 
	}
	
	static void dfs(int idx, int cnt, int sev) {
		
		if(sev==7) {
			bfs();
			return;
		}
		
		if(cnt==25) return;
		
		c[idx] = cnt;
		dfs(idx+1, cnt+1, sev+1); //�����ϱ�
		dfs(idx, cnt+1, sev); //���þ��ϰ� �Ѿ
	}
	
	static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean [] visited = new boolean[7];
		
		que.add(c[0]);
		visited[0] = true;
		
		int cnt =0;int s=0;
		while(!que.isEmpty()) {
			int now = que.poll();
			
			int nx = now/5;
			int ny = now%5;
			
			if(map[nx][ny]==1) s++;
			
			for(int i=0;i<4;i++) {
				//�����¿쿡 7���߿� �ִ��� üũ
				int nextx = nx + dx[i];
				int nexty = ny + dy[i];
				for(int j=0;j<7;j++) {
					int ourx = c[j]/5;
					int oury = c[j]%5;
					//�湮���� �� + x�� y��ǥ�� ����
					if(!visited[j] ) {
						if(nextx ==ourx && nexty ==oury) {
							visited[j]= true;
							que.add(c[j]);
							cnt++;
						}
					}
				}
			}
		}
		
		if(cnt==6 && s>=4) {
			ans++;
		}
		
	}
}
