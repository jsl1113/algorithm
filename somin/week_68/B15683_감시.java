import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 
 * 너무 많은 경우의 수를 어떻게 계산해야하는지 어려워서 포기.
 * 역대급 백트래킹+dfs문제같다... 복잡했지만 정답은 왜 깔끔하지?
 * 
 * 0 : 빈칸
 * 1~5 : cctv번호
 * 6 : 벽 
 * 
 * 답: 
 * cctv가 각자 가능한 모든 경우를 dfs로 탐색하고 
 * cctv의 위치는 lst에 저장
 * cctv의 방향을 2차원배열 cctvs에 저장 
 * 		-> 1,2,3,4,5번을 각자 방향을 0,1,2,3으로 미리 저장해놓음 
 * 			-> 이걸 4방향으로 돌리면서 체크
 * 			= for문을 4방향으로 돌리고 (i)에 더하고 %4해줘서 방향을 0,1,2,3 중에 나오게 함
 * dfs진행과 return이 있기 때문에 map을 되돌리기 위해 copy함수를 만들어 사용함
 * 모든 cctv를 다 체크하면 현재 map의 0의 개수 세기
 *  
 */
public class B15683_감시 {

	static int n,m;
	static ArrayList<CCTV> lst = new ArrayList<>();
	static int minAns = Integer.MAX_VALUE;
	static int[][] move = { //상하좌우로 이동
			{0,1}, 
			{1,0},
			{0,-1},
			{-1,0}
	};
	static int[][] cctvs = {
			{},
			{0},       // 상
			{0,2},     // 상하
			{0,1},     // 상우
			{0,1,2},   // 상우하
			{0,1,2,3}  // 상우하좌
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] arr =new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0 && arr[i][j]<6) {
					lst.add(new CCTV(i, j, arr[i][j]));
				}
			}
		}
		
		//경우의 수 체크
		dfs(0, arr);
		System.out.println(minAns);
	}
	
	static void dfs(int cnt, int[][] map) {
		if(cnt == lst.size()) { //모든 cctv 체크함
			//0갯수 세기
			
			minAns = Math.min(minAns, countZero(map));
			return;
		}
		
		//cnt번째 cctv의 방향 정하기
		int x = lst.get(cnt).x;
		int y = lst.get(cnt).y;
		int num = lst.get(cnt).num;
		for(int i=0;i<4;i++) { //4방향으로 돌리기
			int[][] newMap = copy(map); //복사해서 가져오기
			for(int c : cctvs[num]) {  //num번 cctv  
				int dir = (c+i)%4; //
				
				int nx = x;
				int ny = y;
				
				while(true) {
					nx += move[dir][0];
					ny += move[dir][1];
					
					//범위 나가거나 6을 만나면 out
					if(nx<0 || nx >=n ||ny<0 || ny>=m || map[nx][ny]==6) {
						break;
					}
					newMap[nx][ny] = -1; //지나간 곳
				}
			}
			//이번 cctv 끝나면 다음 거로
			dfs(cnt+1, newMap);
			
		}
	}
	
	static int[][] copy(int[][] map){
		int[][] cpm = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cpm[i][j] = map[i][j];
			}
		}
		
		return cpm;
		
	}
	
	
	
	//0의 갯수 세기 = ans
	static int countZero(int[][] map) {
		int cnt =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	
	static class CCTV{
		int x;
		int y;
		int num;
		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
	

}
