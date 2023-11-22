package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RV_B14226_이모티콘 {

	static int s;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
		              //화면 임티 개수 클립보드 임티 개수 = 방문
		visited = new boolean[2001][2001];
		
		bfs();
	}
	
	static void bfs() {
		Queue<Emo> que = new LinkedList<>();
		que.add(new Emo(1, 0, 0));
		
		while(true) {
			Emo now = que.poll();
			
			int et = now.emot;
			int clip = now.clip;
			int time = now.time;
			
			if(et == s) {
				System.out.println(time);
				break;
			}
			
			//화면에 있는 이모티콘을 복사해 클립보드에 저장
			if(et >0 && !visited[et][et]) {
				visited[et][et] = true;
				que.add(new Emo(et, et, time+1));
			}
			
			//클립보드에 있는 임티를 화면에 붙여넣기
			if(clip!=0 && et+clip<2001 && !visited[et+clip][clip]) {
				visited[et+clip][clip] = true;
				que.add(new Emo(et+clip, clip, time+1));
			}
			//화면에 있는 이모티콘 중 하나 삭제
			if(et>=1 && !visited[et-1][clip]) {
				visited[et-1][clip] = true;
				que.add(new Emo(et-1, clip, time+1));
			}
			
		}
	}

	static class Emo{
		int emot;
		int clip;
		int time;
		Emo(int emot, int clip, int time) {

			this.emot = emot;
			this.clip = clip;
			this.time = time;
		}
	}
}
