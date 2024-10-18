import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
// N개의 자연수 중에서 M개를 고른 수열을 사전순으로 증가하는 순서로 출력하기
public class B15663_N과M9 {

	static int n,m;
	static int[] arr;
	static boolean[] visit;
	static int[] ans;
	static Map<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		ans = new int[m];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
	}
	
	static void dfs(int cnt) {
		
		if(cnt == m) {
			String s = "";
			for(int a : ans) {
				s+= a;
				s+= " ";
			}
			if(!map.containsKey(s)) {
				map.put(s, 1);
				System.out.println(s);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				dfs(cnt+1);
				visit[i] = false;
			}
		}
		
	}
	

}
