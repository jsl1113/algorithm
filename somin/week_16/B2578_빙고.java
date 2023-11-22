package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2578_빙고 {

	static int[][] bingo;
	static boolean[][] checked;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		bingo = new int[5][5];
		checked = new boolean [5][5];
		ans = new int[26];
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int j=0;j<5;j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=1;
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int j=0;j<5;j++) {	
				ans[cnt++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=1;k<=25;k++) {
			
			for(int i=0;i<5;i++) {			
				for(int j=0;j<5;j++) {
					if(ans[k] == bingo[i][j]) {
						checked[i][j] = true;
					}
				}
			}
			if(k>11) {
				boolean flag = check();
				if(flag) {
					System.out.println(k);
					return;
				}
			}
		}
		
	}

	static boolean check() {
		int bg =0;
		//가로 체크
		for(int i=0;i<5;i++) {
			int cnt=0;			
			for(int j=0;j<5;j++) {	
				if(checked[i][j]) {
					cnt++;
				}
				if(cnt==5) {
					bg++;
				}
			}
		}
		
		//세로 체크 
		for(int i=0;i<5;i++) {
			int cnt=0;			
			for(int j=0;j<5;j++) {	
				if(checked[j][i]) {
					cnt++;
				}
				if(cnt==5) {
					bg++;
				}
			}
		}
		//대각선 체크
		int ct=0;
		for(int i=0;i<5;i++) {
			if(checked[i][i]) {
				ct++;
			}
			if(ct==5) {
				bg++;
			}
		}
		ct=0;
		for(int i=0;i<5;i++) {
			if(checked[i][4-i]) {
				ct++;
			}
			if(ct==5) {
				bg++;
			}
		}
		
		if(bg>=3) {
			return true;
		}else
			return false;
	}
}
