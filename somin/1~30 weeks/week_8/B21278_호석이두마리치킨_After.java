package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프 탐색/너비 우선 탐색
 * dfs와 bfs로 푸는 방법
 *  1. N개중 2개의 조합 구하기 (치킨집 좌표 구하기) dfs
 *  2. 해당 치킨집일때의 치킨거리 구하기 (최댓값 저장 & 갱신) bfs
 */
public class B21278_호석이두마리치킨_After {

	static int n,m;
	static ArrayList<Integer>[] list;
	
	static int a1=0,a2=0;
	
	//
	static int ans = Integer.MAX_VALUE;
	static int select[] = new int[2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
	
		for(int i=0;i<=n;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
//		System.out.println(Arrays.deepToString(list));

		dfs(1,0);
		
		System.out.println(a1+" "+a2+" "+ans*2);
	}
	static void dfs(int start, int cnt) {
        if(cnt == 2){
//        	System.out.println(select[0]+" , "+select[1]);
        	bfs();
            return;
        }
 
        /*
         * isVisited를 쓰지 않고 select[cnt]를 활용해 
         * 어차피 cnt는 0과 1일때만 존재하니까 여기에 i값을 저장해놓을 생각을 못했다.
         * 다음부턴. 써먹어보자.
         */
        for (int i = start; i <= n; i++) {
 
            select[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }
	
	public static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(select[0]);
		q.offer(select[1]);
		 int dist[] = new int[n + 1];
	        boolean visit[] = new boolean[n + 1];
	        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
	        dist[select[0]] = 0;
	        dist[select[1]] = 0;
	 
	        /*
	         * 너무 똑똑한 방법
	         * 예를 들어 치킨집이 (4, 5) 면 4, 5를 큐에 넣고 
	         *  (4, 5)의 치킨거리는 0으로 초기화,
	         *  나머지 치킨집은 최대정수로 초기화
	         *  큐에서 poll 한 (4)-> list[4]의 원소(2)의 치킨거리와 4의 치킨거리와 비교하면 당연히 2의 치킨거리가 높음 
	         *  그리고 4의 원소가 2이기때문에 둘은 이어져있음. 그래서 2의 치킨거리 = 4의 치킨거리 +1 해주기
	         *  그리고 2를 계산했으므로 큐에 2를 넣고, visit[2]=true;
	         *  ----- 다음은 5인데 똑같이 2이므로 치킨거리는 동일.
	         *  -----이제 x = 2 일때 list[2]의 원소는 4,5,3 
	         *  4와 5의 치킨거리는 0이므로 if조건 나가기. 둘 다 !visit 이고, 이때 visit이 둘 다 true 바뀜
	         *  원소 3이 k일 경우, 3의 치킨거리가 최대정수여서 3의 치킨거리 = 2의 치킨거리 + 1 = 2 (4와 5로부터 2개 떨어져있음)
	         *  .....
	         *  이런식으로 진행해서 모든 치킨거리를 다 구하고 합을 sum에 더함.
	         *  최댓값을 ans에 저장하고 select[0],[1]도 저장. => 정답.    
	         */
	        while (!q.isEmpty()) {
	            int x = q.poll();
	 
	            for (int k : list[x]) {
	                if(dist[k] > dist[x] + 1) dist[k] = dist[x] + 1;
	                if(visit[k]) continue;
	                q.offer(k);
	                visit[k] = true;
	            }
	        }
	        int sum = 0;
	 
	        for (int i = 1; i <= n; i++) {
	            sum += dist[i];
	        }
	 
	        /*	문제에서 작은 번호가 더 작은 것을, 
	         *  작은 번호가 같다면 큰 번호가 더 작은 걸 출력
	         *  위의 조건은 어차피 dfs에서 작은수부터 조합했기때문에 
	         *  ans > sum 만해도 충분함.
	         */
	        if(ans > sum){
	            ans = sum;
	            a1 = select[0];
	            a2 = select[1];
	        }
		
	}
	


}
