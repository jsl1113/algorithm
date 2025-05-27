
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//string & map
public class B22233_가희와키워드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			map.put(br.readLine(), 1);
		}
		
		int cnt = n;
		for(int i=0;i<m;i++	) {
			String[] blog = br.readLine().split(",");
			for(String now : blog) {
				if(map.containsKey(now)) {
					if(map.get(now)==1) {
						cnt--;
						map.put(now, 0);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
		
	}

}
