package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * dfs()�Ŀ� �ϴ� �ڵ带 �Ϸ��ٰ� ���� ������ ��� ���ϱ� �����ϴ�
 * �̹��� ����ó�� ���� �Ʒ��κа� ������ �κ� �ȿ� ���� ��ƼĿ�� ���� �� �ִ�
 * �׷��� ������ ���� ���� �� �� ũ�� ���ϸ� ���̸� ���ؼ� ans�� �ִ´�
 */
public class B16937_�ν�ƼĿ {

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
	
	//1�� ��ƼĿ ���̱�
	static void sticker() {
		for(int i=0;i<list.size();i++) {
			Sticker ss = list.get(i); // r,c
			int restS = h - ss.r;
			int restG = w - ss.c;
			int area = ss.r *ss.c;
			
			if(restG>=0 && restS>=0) {
				second(i, restS, restG, area);
			}
			
			//ȸ���ϰ� ���̱�
			restS = h - ss.c;
			restG =  w - ss.r;
			if(restG>=0 && restS>=0) {
				second(i, restS, restG, area);
			}
		}
	}

	//2�� ��ƼĿ ���̱�
	static void second(int idx, int restS,int restG, int area) {
		int area2 = 0;
		for(int i=idx+1;i<list.size();i++) {
			Sticker ss = list.get(i);
			
			//���� restS ���� w
			//���� h ���� restG
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
