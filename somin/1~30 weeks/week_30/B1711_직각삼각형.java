import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1711_직각삼각형 {

	
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			p[i] = new Point(a, b);
			
		}
		
		int cnt = 0;
		
		//점 세개 선택
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					long ax = p[i].x;
					long ay = p[i].y;
					long bx = p[j].x;
					long by = p[j].y;
					long cx = p[k].x;
					long cy = p[k].y;
					
					long a2 = (ax - bx)*(ax - bx) + (ay-by)*(ay-by);
					long b2 = (bx - cx)*(bx - cx) + (by-cy)*(by-cy);
					long c2 = (cx - ax)*(cx - ax) + (cy-ay)*(cy-ay);
					
					if(a2+b2==c2 || a2+c2==b2 || c2+b2==a2) {
						cnt++;
					}
				}
			}
		}
		
		
		
		System.out.println(cnt);
		
	}
	
	
	static class Point {
	    long x, y;
	    
	    public Point(long x, long y) {
	        this.x = x;
	        this.y = y;
	    }
	}

}
