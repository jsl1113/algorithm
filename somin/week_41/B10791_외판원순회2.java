import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B10791_외판원순회2 {
	
	static int n,m;
	static int[][] map;
	static int ans = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		
		map = new int[n][m];
		int nums[] = new int[10];
		
		if(n==1 || m==1) {
			System.out.println(1);
			return;
		}
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j) - '0';
				nums[map[i][j]]++;
			}
		}
		
		// 숫자의 개수가 4개 이상
		boolean fourOver[] = new boolean[10];
		for(int i=0;i<=9;i++) {
			if(nums[i]>=4) {
				fourOver[i] = true;
			}
		}
		
		//0~9까지 check
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				if(fourOver[map[i][j]]) {
					List<Integer> list = (List<Integer>) Arrays.stream(map[i]).boxed().collect(Collectors.toList());
					int count = Collections.frequency(list, map[i][j]);
					// 같은 행과 열에 최소 2개
					if(count>=2) {
						check(count, i, j, map[i][j]);
					}
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	static void check(int count, int x, int y, int now) {
		int cnt = 0;
		
		for(int i=y+1;i<m;i++) {
			if(cnt == count) {
				break;
			}
			if(map[x][i] == now) {
				int dist = (i-y);	
				//가로에 있다면 그 아래에 있어야한다.
				/*  1 0 1
				 *  0 0 0
				 *  1 0 1
				 */
				if(x+dist <n && y+dist <m && map[ x+dist][y] == now  && map[x+dist][y+dist] == now  ) {
					ans = Math.max(ans, (dist+1)*(dist+1));
				}
				cnt++;
			}
		}
		
	}
	
	
}
