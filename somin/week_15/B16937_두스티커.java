package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * dfs()후에 하는 코드를 하려다가 남은 공간에 어떻게 붙일까 생각하다
 * 이미지 파일처럼 왼쪽 아래부분과 오른쪽 부분 안에 들어가면 스티커를 붙일 수 있다
 * 그래서 간단히 가로 세로 비교 후 크기 이하면 넓이를 합해서 ans에 넣는다
 */
public class B16937_두스티커 {

	static int h,w,n;
	static ArrayList<Sticker> list = new ArrayList<>();
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if((r>h && r>w )|| (c>h && c>w )) continue;
			
			list.add(new Sticker(r, c));
			
		}
		
		sticker();
		System.out.println(ans);
	}
	
	//1번 스티커 붙이기
	static void sticker() {
		for(int i=0;i<list.size();i++) {
			Sticker ss = list.get(i); // r,c
			int restS = h - ss.r;
			int restG = w - ss.c;
			int area = ss.r *ss.c;
			
			if(restG>=0 && restS>=0) {
				second(i, restS, restG, area);
			}
			
			//회전하고 붙이기
			restS = h - ss.c;
			restG =  w - ss.r;
			if(restG>=0 && restS>=0) {
				second(i, restS, restG, area);
			}
		}
	}

	//2번 스티커 붙이기
	static void second(int idx, int restS,int restG, int area) {
		int area2 = 0;
		for(int i=idx+1;i<list.size();i++) {
			Sticker ss = list.get(i);
			
			//세로 restS 가로 w
			//세로 h 가로 restG
			if((ss.r<=restS && ss.c<=w) || (ss.r<=h && ss.c<=restG) ||
			   (ss.c<=restS && ss.r<=w) || (ss.c<=h && ss.r<=restG)) {
				area2 = Math.max(area2, ss.r*ss.c);
			}
		}
		
		if(area2 ==0) return;
		ans = Math.max(ans, area+area2);
		
		
	}

	static class Sticker {
		int r;
		int c;
		public Sticker(int r,int c) {
			this.r = r;
			this.c = c;
		}
		
	}
}
