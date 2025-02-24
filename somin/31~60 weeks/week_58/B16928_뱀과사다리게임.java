import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//���� ������ �����ΰ�? �ƴ� �� ����
public class B16928_�����ٸ����� {
	
	static int n,m;
	static int[] visit = new int[106];
	static Map<Integer, Integer> jump = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			jump.put(x,y);
		}

		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			jump.put(x,y);
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(1);
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == 100) {
				System.out.println(visit[100]);
				break;
			}
			
			for(int i=1;i<=6;i++) {
				int num = now + i;
				
				if(jump.containsKey(num)) {
					num = jump.get(num);
				}
				if(visit[num]==0) {
					visit[num] = visit[now]+1;
					que.add(num);
				}
				
			}
			
		}
		
	}
	
	


}
