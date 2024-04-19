package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * N명 중에 모든 팀의 경우의 수를 생각해서 팀의 능력치 차이의 최소값 구하기
 * 못 푼 이유 : 부분집합을 구하는 방법을 몰랐다. 순열과 조합의 차이 헷갈림
 * 부분 집합을 구하고 나서는 내 방식대로 풀었다 / 비트마스킹은 모르겠다.
 */
public class B15661_링크와스타트 {

	static int n;
	static int [][] s;
	static boolean []isTeam;
	static int distMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = new int[n][n];
		isTeam=new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);
		
		System.out.println(distMin);

	}

	// 부분집합을 구하는 함수 
	public static void dfs(int cnt ) {
		if(cnt==n) {
			int tcheck=0;
			for (int i = 0; i < n; i++) {
	            if (isTeam[i] == true) {
	            	tcheck ++;
	            }
	        }
			if(tcheck>1 && tcheck<n-1) {
				dist();
			}
	        return;
		}
		
		isTeam[cnt] = true;
		dfs(cnt+1);
		
		isTeam[cnt] = false;
		dfs(cnt+1);
	}
	/*
	 *    두 팀의 차이의 최솟값 구하는 함수
	 * 1. 모든 부분집합 경우를 가져오기 
	 * (dfs함수에서 1 : n-1 로 나눠지는 부분함수는 제외함) - > n = 4 일때 1/2 3 4 인 경우 차이가 최소값일 수 없기때문
	 * 2. true 인 경우 start 어레이리스트에 넣고 나머지 link팀
	 * 3. 각 팀의 능력치 더하기 (이중for문)
	 * 4. 능력치 차이를 저장하고 최솟값을 distMin에 저장
	 */
	public static void dist() {
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<Integer> link = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
            if (isTeam[i] == true) {
            	start.add(i+1);
            }else {
            	link.add(i+1);
            }
        }
		
		int sumS =0; 
		int sumL =0; 

		for(int i: start) { 
			for(int j: start) { 
				sumS+=s[i-1][j-1];
			}
		}
		for(int i: link) {
			for(int j: link) { 
				sumL+=s[i-1][j-1];
			}
		}
		
		distMin = Math.min(distMin, Math.abs(sumS-sumL));

	}

}
