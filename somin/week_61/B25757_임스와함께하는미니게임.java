import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B25757_임스와함께하는미니게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		char c = st.nextToken().charAt(0);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int mem = 0;
		if(c == 'Y') {
			mem = 2;
		}else if(c == 'F') {
			mem = 3;
		}else {
			mem = 4;
		}
		
		int cnt=1;
		int ans=0;
		
		for(int i=0;i<n;i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
			}else {
				cnt++;
				map.put(name, 1);
			}
			if(cnt == mem) {
				cnt = 1;
				ans++;
			}
		}
		System.out.println(ans);
	}

}
