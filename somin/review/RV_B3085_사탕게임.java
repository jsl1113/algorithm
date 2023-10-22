package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * swap�� �������� �ߴµ� �� ���� ���� �����Ѵٰ� �����ߴ���..
 * ���� ��￡ �����ؼ� ������.. ����� ���Դ�
 * 
 * �ϳ� �ϳ� �ٲ㼭 ��� ��츦 �� üũ�ϴ� ���� �ذ����̿���...
 */
public class RV_B3085_�������� {

	static int n;
	static Character [][] map;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new Character[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		
		//��üũ
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				char c = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = c;
				
				//
				check();
				
				c = map[i][j+1];
				map[i][j+1] = map[i][j];
				map[i][j] = c;
				
			}
		}
		
		
		
		//��üũ
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				Character c = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = c;
				
				max = Math.max(max, check());
				
				c = map[j+1][i];
				map[j+1][i] = map[j][i];
				map[j][i] = c;
				
			}
		}
		
		
		System.out.println(max);
		
	}
	public static int check() {
		
		//����
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(map[i][j]==map[i][j+1]) {
					cnt++;
				}
				else {					
					cnt=1;
				}
				max =Math.max(max, cnt);
			}
		}
		
		//����
		
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
				}
				else {					
					cnt=1;
				}
				max =Math.max(max, cnt);
			}
		}
		return max;
		
	}
	
}
