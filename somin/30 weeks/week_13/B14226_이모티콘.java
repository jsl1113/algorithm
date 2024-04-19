package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 1. ���� �ִ� ��Ƽ���� ����ϱ�
 * 2. ����س��� ��Ƽ���� ���ϱ�
 * 3. ���� �ִ� ��Ƽ 1�� ����
 * 
 * ��. Ŭ������ ��� �����ִٴ� ����� ���� �ſ� ��̴�
 * [������Ƽ����][Ŭ��������Ƽ����] 
 *  bfs
 * ��� ����� ���� ����ؼ� s�� ������ break
 * �ּڰ��� ���ؾ��ϱ� ������ �湮ó����
 * �̸�Ƽ���� �ִ� �����ϸ� 2000�� �� �� �־ 2001�� ���� ����
 */
public class B14226_�̸�Ƽ�� {

	static int s;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = Integer.parseInt(br.readLine());
		
		//               ȭ����Ƽ ���� / Ŭ����Ƽ ���� 
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
