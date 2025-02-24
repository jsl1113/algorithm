import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기 {

	static int l,c;
	static String[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visit = new boolean[c];
		arr = new String[c];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<c;i++) {
			arr[i] = (st.nextToken());
		}
		
		Arrays.sort(arr);
		
		String[] ans = new String[l];
		dfs(0, ans, 0);
		System.out.println(sb);
	}
	
	static void dfs(int cnt, String[] ans, int num) {
		if(cnt==l) {
			if(check(ans)) {
				for(String ss: ans) {
					sb.append(ss);
				}sb.append("\n");
			}
			return;
		}
		
		for(int i=num;i<c;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ans[cnt] = arr[i];
				dfs(cnt+1, ans, i+1);
				visit[i] = false;
			}
		}
		
	}
	
	static boolean check(String[] ans) {
		int m=0;
		int j=0;
		for(int i=0;i<ans.length;i++) {
			if(ans[i].equals("a") || ans[i].equals("e") || ans[i].equals("i")
					|| ans[i].equals("o") || ans[i].equals("u")) {
				m++;
			}else {
				j++;
			}
		}
		
		if(m>=1 && j>=2) {
			return true;
		}else
			return false;
	}

}
