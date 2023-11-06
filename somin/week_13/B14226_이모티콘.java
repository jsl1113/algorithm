package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 1. 현재 있는 임티개수 기억하기
 * 2. 기억해놓은 임티개수 더하기
 * 3. 현재 있는 임티 1개 삭제
 * 
 * 와. 클립보드 계속 남아있다는 사실을 몰라서 매우 헤맸다
 * [현재임티개수][클립보드임티개수] 
 *  bfs
 * 모든 경우의 수를 계산해서 s와 같으면 break
 * 최솟값을 구해야하기 때문에 방문처리함
 * 이모티콘이 최대 복붙하면 2000개 될 수 있어서 2001로 범위 넣음
 */
public class B14226_이모티콘 {

	static int s;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
		
		//               화면임티 개수 / 클립임티 개수 
		visited = new boolean[2001][2001]; 
		bfs();
	}
	
	public static void bfs() {
		Queue<ET> que = new LinkedList<>();
		que.add(new ET(1, 0, 0));
		
		while(!que.isEmpty()) {
			ET now = que.poll();
			
			int emoticon = now.emoticon;
			int clip = now.clipEmo;
			int time = now.time;
			
			if(emoticon==s) {
				System.out.println(time);
				break;
			}
			
			if(emoticon>0) {
				if(!visited[emoticon][emoticon]) {
					visited[emoticon][emoticon]=true;
					que.add(new ET(emoticon, emoticon, time+1));
				}
				
				if(!visited[emoticon-1][clip]) {
					visited[emoticon-1][clip]= true;
					que.add(new ET(emoticon-1, clip, time+1));
				}
			}
			
			if(clip>0 && emoticon+clip<2000) {
				if(!visited[emoticon+clip][clip]) {
					visited[emoticon+clip][clip]=true;
					que.add(new ET(emoticon+clip, clip, time+1));
				}
			}
			
			
		}
	}
	
	public static class ET{
		int emoticon;
		int clipEmo;
		int time;
		ET(int emoticon, int clipEmo, int time){
			this.clipEmo=clipEmo;
			this.emoticon=emoticon;
			this.time = time;
		}
	}

}
