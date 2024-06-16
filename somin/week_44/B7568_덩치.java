import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B7568_µ¢Ä¡ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		
		int[][] dung = new int[n][2];
		int[] ans = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			dung[i][0] = w;
			dung[i][1] = h;
		}
		
		for(int i=0;i<n;i++) {
			int cnt=0;
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				if(dung[i][0]<dung[j][0] &&dung[i][1]<dung[j][1] ) {
					cnt++;
				}
			}
			ans[i] = cnt+1;
		}

		for(int ii : ans) {
			System.out.println(ii);
		}
	}

}
