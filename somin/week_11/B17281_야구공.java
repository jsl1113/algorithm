package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * �ϴ� ������ �ټ���� ����� 4��Ÿ�ڸ� �����ϰ� dfs�ϴ� ��
 * 
 * �ٵ� ������ �����ϴ� ����� ��¦ ���ذ� �Ȱ���.. 
 * 
 * ���� ���ذ� �ʹ� �ȵż� ã�ƺôµ��� ������ �ڼ��� �� ����..
 * �ϳ��� ����غ���� �ߴµ� ������ ����.. ����... 
 * �÷��̾� ������ �������� ������� �����ؾ��ϴ� ���� �ƴѰ�? �� �ٸ� �� ����
 */
public class B17281_�߱��� {

	static int n;
	static int []player = new int[10];
	static boolean[] visited = new boolean[10];
	static int[][] arr;
	static int ans=0;
	
	static int vv=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][10];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<10;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player[4] = 1;
		visited[4] = true;
		
		P(2);
		
		System.out.println(ans);
	}
	
	public static void P(int cnt) {
		
		if(cnt == 10) {
			//���ӽ��� + �����ִ� ���ϱ�
			
			ans = Math.max(ans, simulate());
			return;
		}
		
		
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				player[i] = cnt;
				P(cnt+1);
				visited[i] = false;
				
			}
		}
		
	}
	
	public static int simulate() {
		int idx=1;
		int score=0;
		
		for(int i=0;i<n;i++) {
			boolean[] base = new boolean[4];
			int outcnt=0;
			while(outcnt<3) {
				
				int nowHit = arr[i][player[idx]];
				idx++;
				if(idx>9) idx =1;
				
				if(nowHit ==0 ) {
					outcnt++;
				}else if(nowHit == 1) {
					if(base[3]) score++;
					base[3] = base[2];
					base[2] = base[1];
					base[1] = true;
				}else if(nowHit == 2) {
					if(base[3]) score++;
					if(base[2]) score++;
					base[3] = base[1];
					base[2] = true;
					base[1] = false;
				}else if(nowHit == 3) {
					if(base[3]) score++;
					if(base[2]) score++;
					if(base[1]) score++;
					base[3] = true;
					base[2] = false;
					base[1] = false;
				}else if(nowHit == 4) {
					if(base[3]) score++;
					if(base[2]) score++;
					if(base[1]) score++;
					score++;
					base[3] = false;
					base[2] = false;
					base[1] = false;
				}
				
				
			}
			
		}
		
		return score;
	}
	
	
}
