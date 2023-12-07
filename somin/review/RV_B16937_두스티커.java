package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B16937_두스티커 {

	static int h,w,n,r,c;
	static ArrayList<st> list= new ArrayList<>();
	static int ans= 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		n = Integer.parseInt(br.readLine());


		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if( (r>h &&r>w) || (c>h && c>w)) continue;
			list.add(new st(r, c));
		}

		firstSt();
		System.out.println(ans);
	}
	
	static void firstSt() {
		for(int i=0;i<list.size();i++) {
			st now = list.get(i);
			int rn = now.r;
			int cn = now.c;
			
			if(h >=rn && w >=cn) { /////////////////
				SecondSt(i+1, rn, cn);
				
			}
//			SecondSt(i+1, rn, cn);
			
			//r 과 c 교환
			if(h >=cn && w >=rn) { ///////////////// 이 조건을 빼먹었다
				SecondSt(i+1, cn, rn);
				
			}
		}
	}
	
	static void SecondSt(int idx,int rn, int cn) {
		int mtp=0;
		for(int i=idx;i<list.size();i++) {
			st next = list.get(i);
			int rs = next.r;
			int cs = next.c;
			
			if(( (h-rn) >= rs && w >= cs ) ||
			   ( (h-rn) >= cs && w >= rs ) ||
			   ( (w-cn) >= cs && h >= rs ) ||
			   ( (w-cn) >= rs && h >= cs ) 	) {
				mtp = Math.max(mtp, rs*cs);
			}
		}
		if(mtp!=0) {
			ans = Math.max(ans, mtp + rn*cn);
		}
		
	}
	
	
	static class st{
		int r;
		int c;
		public st(int r,int c){
			this.r = r;
			this.c=c;
		}
	}
	


}
