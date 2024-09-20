import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1062_°¡¸£Ä§ {

	static int n,k;
	static String[] arr; 
	static boolean[] visit;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new String[n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			s = s.replace("anta", "");
			s = s.replace("tica", "");
			arr[i] = s;
		}
		if(k<5) {
			System.out.println(0);
			return;
		}else if(k==26) {
			System.out.println(n);
			return;
		}
		
		visit = new boolean[26];
		visit['a'-'a'] = true;
		visit['c'-'a'] = true;
		visit['i'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		
		bt(0,0);
		System.out.println(ans);
		
	}

	static void bt(int now, int len) {
		if(len == k-5) {
			int cnt = 0;
			for(int i=0;i<n;i++) {
				boolean flag = true;
				for(int j=0;j<arr[i].length();j++) {
					if(!visit[arr[i].charAt(j)-'a']) {
						flag = false;
						break;
					}
				}
				if(flag) cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		for(int i=now;i<26;i++) {
			if(visit[i] == false) {
				visit[i] = true;
				bt(i,len+1);
				visit[i] = false;
			}
		}
		
		
	}
}
