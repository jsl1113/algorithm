import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 노답 하나. map으로 중복제거해서 제출 map.size()-1 (1은 무조건 있다고 판단한 것이 잘못)
// 노답 둘. dfs에서 if(!visit[i]) 으로 하면 1 2, 2 3 인 경우 2는 이미 t여서 3을 친구로 계산 불가
// 정말 쉬워보였지만 아니었다.
public class B5567_결혼식 {

	
	static int n,m,ans=0;
	static ArrayList<Integer>[] friends;
	static boolean visit[]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1];
		friends = new ArrayList[n+1];
		
		for(int i=0;i<=n;i++) friends[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);             
		}
		

		boolean flag = false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer ii : friends[1]) {
			if(ii==1) flag = true;
			map.put(ii, 1);
				for(Integer t : friends[ii]) {
					if(t==1) flag = true;
					map.put(t, 2);
				}
		}
		
		if(flag) {
			System.out.println(map.size()-1);
		}
		else {
			System.out.println(map.size());
		}


	}
	
	static void dfs(int cnt, int now) {
		
		if(cnt == 2) {
			return;
		}
		
		
		for(Integer i : friends[now]) {
			visit[i] = true;
			dfs(cnt+1, i);
		}
		
		
	}

}
