import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18429_±Ù¼Õ½Ç {

	static int n,k;
	static int[] arr;
	static int[] ans;
	static boolean[] visit;
	
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		ans = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		
		System.out.println(result);
	}
	
	static void dfs(int cnt) {
		
		if(cnt == n) {
//			System.out.println(Arrays.toString(ans));
			if(check()) {
				result++;
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				ans[i] = (cnt+1);
				visit[i] = true;
				dfs(cnt+1);
				visit[i] = false;
			}
		}
	}
	
	static boolean check() {
		
		int weight = 500;
		
		for(int i=0;i<n;i++) {
			weight -=k;
			weight += arr[ans[i]-1];
			
			if(weight<500) {
				return false;
			}
		}
		
		return true;
	}

}
