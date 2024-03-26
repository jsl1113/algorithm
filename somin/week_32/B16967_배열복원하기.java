import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16967_배열복원하기 {

	static int h,w,x,y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		int r = (h+x);
		int c = (w+y);
		
		int [][] ans = new int[h][w];
		
		int [][] before = new int[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
				
				if(i<h && j<w) {
					ans[i][j] = before[i][j];
				}
			}
		}
		
		for(int i=x;i<h;i++) {
			for(int j=y;j<w;j++) {
				ans[i][j] = Math.abs(ans[i][j] - ans[i-x][j-y]);
			}
		}
		
		for(int[] arr : ans) {
			for(int a : arr) {
				System.out.print(a+" ");
			}System.out.println();
		}
		
	}

}
