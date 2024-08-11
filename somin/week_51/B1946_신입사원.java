import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1946_신입사원 {

	static int t,n;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (o1,o2) ->{
				return o1[0]-o2[0];
			});

			int cnt =0;
			int rank = arr[0][1];
			
			for(int j=0;j<n;j++) {
				if(rank < arr[j][1]) {
					cnt++;
				}else if(rank >arr[j][1]) {
					rank = arr[j][1];
				}
			}
			
			System.out.println(n-cnt);
			
		}

	}

}
