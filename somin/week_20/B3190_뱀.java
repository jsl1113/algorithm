package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3190_�� {

	
	static int n,k,l;
	static int[][] map;
	static ArrayList<int []> bam = new ArrayList<int[]>();
	static int[][] rotation;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a-1][b-1] = 1;
		}
		
	
		l = Integer.parseInt(br.readLine());
		rotation = new int[l+1][2];
		
		for(int i=0;i<l;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			rotation[i][0] = sec;
			if(dir.equals("D")) {
				rotation[i][1] = 1;
			}else {
				rotation[i][1] = -1;
			}
		}
		
		bam();
		
	}
	
	static void bam() {
		
		int time=0;
		int lcnt=0;
		int rot = 0;
		int x = 0;
		int y = 0;
		bam.add(new int[] {0,0});
		
		while(true) {
			
			time++;
			
			int nx = x +dx[rot]; 
			int ny = y +dy[rot]; 
			
			//���� �ε����ų� ���ִ� �� ��������
			if(nx<0 ||nx>=n ||ny<0 ||ny>=n) break;
			if(isBam(nx, ny)) break;
			
			//���� �� ���� ����� �ִ� (���� ���ֿ�) ����+1
			if(map[nx][ny]==1) {
				map[nx][ny] = 0;
				bam.add(new int[] {nx,ny});
				
			}else if(map[nx][ny]==0) {  //���� �� ���� ����� ���� (���� �ֿ� )
				bam.add(new int[] {nx,ny});
				bam.remove(0);
			}
			
//			System.out.println(time+"�ð� > "+rotation[lcnt][0] +" /"+rotation[lcnt][1]);
			if(time == rotation[lcnt][0]) {
				//�Լ� �Ӹ� ������
				rot = head(rot, rotation[lcnt][1]);
				lcnt++;
			}
			
			x = nx; y = ny;
		}
		
		System.out.println(time);
		
		
	}
	static boolean isBam(int nx,int ny) {
		
		for(int i=0;i<bam.size();i++) {
			if(nx == bam.get(i)[0] && ny == bam.get(i)[1]) {
				return true;
			}
		}

		return false;
	}
	static int head(int now, int LR) {
		//0~3
		int num = (now + LR)%4;
		if(num<0) {
			num = (num+4)%4;
		}
		
		return num;
	}

	
}
