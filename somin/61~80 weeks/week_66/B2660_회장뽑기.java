import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2660_»∏¿ÂªÃ±‚ {

	static int n;
	static ArrayList<Integer>[] arr;
	static int min = 50;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		
		rank = new int[n+1];
		arr = new ArrayList[n+1];
		for(int i=0;i<=n;i++) arr[i] = new ArrayList<Integer>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==-1&&b==-1) {
				break;
			}
			
			arr[a].add(b);
			arr[b].add(a);
			
		}
		for(int i=1;i<=n;i++) {
			int v = bfs(i);
			rank[i] = v;
			min = Math.min(min, v);
		}
		int cnt =0;
		for(int i=1;i<n+1;i++) {
			if(rank[i]==min) {
				cnt++;
			}
		}
		System.out.println(min+" "+cnt);
		
		for(int i=1;i<=n;i++) {
			if(min == rank[i]) {
				System.out.print(i+" ");
			}
		}
	}
	
	static int bfs(int now) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{now, 0});
        boolean[] visit = new boolean[n+1];
        visit[now] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int distance = current[1];

            for (int next : arr[node]) {
                if (!visit[next]) {
                    q.add(new int[]{next, distance + 1});
                    visit[next] = true;
                }
            }
            count = distance;
        }
        return count;
    }

}
