package BOJ.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_색종이만들기 {

	static int n;
	static int[][] arr;
	
	static int[] ans= new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		cut(n, 0, 0);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		
		
	}
	
	static void cut(int m, int x, int y) {
				
		
		if(isSame(m, x, y)) {
			ans[arr[x][y]]++;
			return;
		}
		
		//4개로 나누어서 시작
		cut(m/2, x, y);
		cut(m/2, x, y+m/2);
		cut(m/2, x+m/2, y);
		cut(m/2, x+m/2 , y+m/2 );
		
		
	}
	
	static boolean isSame(int m, int x, int y) {
		
		for(int i=x;i<x+m;i++)	{
			for(int j=y;j<y+m;j++) {
				if(arr[i][j]!=arr[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	
 
}
