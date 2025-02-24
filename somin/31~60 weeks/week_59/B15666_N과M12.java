import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
//중복제거와 정렬을 한번에 할 수 없는가...
public class N과M12 {

	static int n,m;
	static int[] arr;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = new int[m];
		
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		n = set.size();
		arr = new int[n];
		int idx=0;
		for(int s : set) {
			arr[idx++] = s;
		}
		Arrays.sort(arr);
		dfs(0,0);
	}
	
	static void dfs(int now, int idx) {
		if(now == m) {
			for(int a : ans) {
				System.out.print(a+" ");
			}System.out.println();
			return;
		}
		
		for(int i=idx;i<n;i++) {
			ans[now] = arr[i];
			dfs(now+1, i);
		}
		
	}

}
