package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * �׷��� Ž��/�ʺ� �켱 Ž��
 * dfs�� bfs�� Ǫ�� ���
 *  1. N���� 2���� ���� ���ϱ� (ġŲ�� ��ǥ ���ϱ�) dfs
 *  2. �ش� ġŲ���϶��� ġŲ�Ÿ� ���ϱ� (�ִ� ���� & ����) bfs
 */
public class B21278_ȣ���̵θ���ġŲ_After {

	static int n,m;
	static ArrayList<Integer>[] list;
	
	static int a1=0,a2=0;
	
	//
	static int ans = Integer.MAX_VALUE;
	static int select[] = new int[2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
	
		for(int i=0;i<=n;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
//		System.out.println(Arrays.deepToString(list));

		dfs(1,0);
		
		System.out.println(a1+" "+a2+" "+ans*2);
	}
	static void dfs(int start, int cnt) {
        if(cnt == 2){
//        	System.out.println(select[0]+" , "+select[1]);
        	bfs();
            return;
        }
 
        /*
         * isVisited�� ���� �ʰ� select[cnt]�� Ȱ���� 
         * ������ cnt�� 0�� 1�϶��� �����ϴϱ� ���⿡ i���� �����س��� ������ ���ߴ�.
         * ��������. ��Ծ��.
         */
        for (int i = start; i <= n; i++) {
 
            select[cnt] = i;
            dfs(i + 1, cnt + 1);
        }
    }
	
	public static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(select[0]);
		q.offer(select[1]);
		 int dist[] = new int[n + 1];
	        boolean visit[] = new boolean[n + 1];
	        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
	        dist[select[0]] = 0;
	        dist[select[1]] = 0;
	 
	        /*
	         * �ʹ� �ȶ��� ���
	         * ���� ��� ġŲ���� (4, 5) �� 4, 5�� ť�� �ְ� 
	         *  (4, 5)�� ġŲ�Ÿ��� 0���� �ʱ�ȭ,
	         *  ������ ġŲ���� �ִ������� �ʱ�ȭ
	         *  ť���� poll �� (4)-> list[4]�� ����(2)�� ġŲ�Ÿ��� 4�� ġŲ�Ÿ��� ���ϸ� �翬�� 2�� ġŲ�Ÿ��� ���� 
	         *  �׸��� 4�� ���Ұ� 2�̱⶧���� ���� �̾�������. �׷��� 2�� ġŲ�Ÿ� = 4�� ġŲ�Ÿ� +1 ���ֱ�
	         *  �׸��� 2�� ��������Ƿ� ť�� 2�� �ְ�, visit[2]=true;
	         *  ----- ������ 5�ε� �Ȱ��� 2�̹Ƿ� ġŲ�Ÿ��� ����.
	         *  -----���� x = 2 �϶� list[2]�� ���Ҵ� 4,5,3 
	         *  4�� 5�� ġŲ�Ÿ��� 0�̹Ƿ� if���� ������. �� �� !visit �̰�, �̶� visit�� �� �� true �ٲ�
	         *  ���� 3�� k�� ���, 3�� ġŲ�Ÿ��� �ִ��������� 3�� ġŲ�Ÿ� = 2�� ġŲ�Ÿ� + 1 = 2 (4�� 5�κ��� 2�� ����������)
	         *  .....
	         *  �̷������� �����ؼ� ��� ġŲ�Ÿ��� �� ���ϰ� ���� sum�� ����.
	         *  �ִ��� ans�� �����ϰ� select[0],[1]�� ����. => ����.    
	         */
	        while (!q.isEmpty()) {
	            int x = q.poll();
	 
	            for (int k : list[x]) {
	                if(dist[k] > dist[x] + 1) dist[k] = dist[x] + 1;
	                if(visit[k]) continue;
	                q.offer(k);
	                visit[k] = true;
	            }
	        }
	        int sum = 0;
	 
	        for (int i = 1; i <= n; i++) {
	            sum += dist[i];
	        }
	 
	        /*	�������� ���� ��ȣ�� �� ���� ����, 
	         *  ���� ��ȣ�� ���ٸ� ū ��ȣ�� �� ���� �� ���
	         *  ���� ������ ������ dfs���� ���������� �����߱⶧���� 
	         *  ans > sum ���ص� �����.
	         */
	        if(ans > sum){
	            ans = sum;
	            a1 = select[0];
	            a2 = select[1];
	        }
		
	}
	


}
