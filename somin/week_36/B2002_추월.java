import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class B2002_추월 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		
		Map<String, Integer> in = new LinkedHashMap<String, Integer>();
		Map<String, Integer> out = new LinkedHashMap<String, Integer>();
		
		//들어갈 때
		int cnt = 0;
		for(int i=0;i<n;i++) {
			in.put(br.readLine(), cnt++);			
		}
		
		//나올 때
		int ans = 0;
		boolean flag = false;
		
		for(int i=0;i<n;i++) {
			String num = br.readLine();
			int inNum = in.get(num);
			out.put(num, inNum);			
			
		}
		
		//나올 때 0부터 시작하는 오름차순의 개수를 세기
		
//		System.out.println(in);
//		System.out.println(out);
		
		int order = 0;
		int now=0;
		
		boolean [] visit = new boolean[n];
		for(Integer key : out.values()) {
			//order하고 같으면 
			if(key==now) {
				ans++;
				now++;
				while(now<n) {
					if(visit[now]) {
						now++;
					}else {
						break;
					}
				}
			}
			
			visit[key] = true;
			order++;
		}
		
		System.out.println(n-ans);
	}

	
}
