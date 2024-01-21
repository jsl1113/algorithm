package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 메모리 초과가 나온다 . 이유는 int [] 를 써서인것 같다 ->아님
 * visited처리를 안해줬었다..... 바보 
 * 
 */
public class RV_B5014_스타트링크_rt {

	
	static int F,S,G,U,D;
	static int[] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dp = new int[F+1];
		visited = new boolean[F+1];
		
		dp[S] =0;
		
		BFS();
		
	}
	
	static void BFS() {
		
		Queue<int []> queue = new LinkedList<>();
		
		queue.add(new int[] {S,0});
		
		
		while(!queue.isEmpty()) {
			
			int[] now = queue.poll();
			
			int stair = now[0];
			int time = now[1];
			
			
			if(stair == G) {
				System.out.println(time);
				return;
			}
			
			//UP
			if(stair+U <=F &&U!=0 &&dp[stair+U]==0) {
				queue.add(new int[] {stair+U,time+1});
				dp[stair+U] = time+1;
			}
			//DOWN
			if(stair-D >0 &&D!=0 && dp[stair-D]==0) {
				queue.add(new int[] {stair-D,time+1});
				dp[stair-D] = time+1;
			}
			
			
		}
		
		System.out.println("use the stairs");
		
	}

}
