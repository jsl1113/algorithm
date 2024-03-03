import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_NQueen {

	static int n;
	static int[] visit;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		visit = new int[n];

		//하나의 행에는 하나의 퀸만.
		// 같은 열에 퀸이 있는지
		//대각선에 퀸이 있는지
		bt(0);
		
		System.out.println(ans);
		
	}
	
	static void bt(int cnt) {
		
		//n개를 전부 채웠으면 정답+1
		if(cnt == n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			visit[cnt] = i;
			if(isQueen(cnt)) {
				bt(cnt+1);
			}
		}
		
		return; 
	}
	
	static boolean isQueen(int cnt) {
		
		for(int i=0;i<cnt;i++) {
			//같은 열에 있으면 false
			if(visit[i] == visit[cnt]) {
				return false;
			}
			
			//대각선에 있으면 false
			if(Math.abs(cnt-i)== Math.abs(visit[cnt] - visit[i]) ) {
				return false;
			}
			
		}
		
		return true;
	}

}
