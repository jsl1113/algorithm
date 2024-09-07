import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B6603_·Î¶Ç {

	static int t;
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			if(t==0) {
				break;
			}
			arr = new int[t];
			for(int i=0;i<t;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			visit = new boolean[t];
			int[] ans = new int[6];
			dfs(0 , 0, ans);
			System.out.println();
		}
		
	}
	
	static void dfs(int cnt, int num, int[] ans) {
		if(cnt==6) {
			for(int aa : ans) {
				System.out.print(aa +" ");
			}System.out.println();
			return;
		}
		
		for(int i=num;i<t;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				dfs(cnt+1, i+1, ans);
				visit[i] = false;
			}
		}
		
		
	}

}
