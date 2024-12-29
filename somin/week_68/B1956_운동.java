import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1956_款悼 {

	static int v,e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		 v = Integer.parseInt(st.nextToken());
		 e = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[v+1][v+1];
		for(int i=0;i<=v;i++) {
			Arrays.fill(arr[i], 4000001); // 400 * 10000
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//老规烹青
			arr[a][b] = c;
		}
		
		for(int i=1;i<=v;i++) {
			for(int j=1;j<=v;j++) {
				for(int k=1;k<=v;k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
				}
			}
		}
		int ans = 4000001;
		for(int i=1;i<=v;i++) {
			ans = Math.min(ans, arr[i][i]);
		}
		
		System.out.println(ans != 4000001 ? ans:-1);
	}
}



