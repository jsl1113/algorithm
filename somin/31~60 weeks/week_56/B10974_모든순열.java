import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10974_모든순열 {

	static int n;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i-1] = i;
		}
		solve(0);
		System.out.println(sb);
		
	}
	
	static void solve(int cnt) {
		if(cnt == n) {
			for(int i=0;i<n;i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				visit[i]= true;
				arr[cnt] = i;
				solve(cnt+1);
				visit[i]= false;
			}
		}
	}

}
