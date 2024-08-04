package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프 탐색/너비 우선 탐색
 * 시간초과 나왔다.
 * 아무래도 bfs하는 방식이 너무 비효율적이다..
 */
public class B21278_호석이두마리치킨 {

	static int n,m;
	static ArrayList<Integer>[] list;
	
	static boolean [] isVisited;
	static boolean [] isVisited2;
	
	static int c1,c2;
	static int a1=0,a2=0;
	
	static int sum=0;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		isVisited = new boolean[n+1];
		isVisited2 = new boolean[n+1];
		
		for(int i=0;i<=n;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
//		System.out.println(Arrays.deepToString(list));

		dfs(0,0);
		
		System.out.println(a1+" "+a2+" "+min);
	}
	//N개 중에 2개 선택하기 (중복x)
	public static void dfs(int cnt, int idx) {
		if(cnt==2) {
			ArrayList<Integer> num = new ArrayList<Integer>();
//			int num[] = new int[2];
			c1=0;c2=0;
			for(int i=0;i<n;i++) {
				if(isVisited[i]) {
//					System.out.print(i+1+" ,");
					num.add(i+1);
//					if(num[0]==0) num[0] = i+1;
//					else
//						num[1] = i+1;
				}
			}
//			System.out.println();
//			System.out.println(num[0]+" num "+num[1]);
			c1 = num.get(0);
			c2 = num.get(1);
//			c1 = num[0];
//			c2 = num[1];
		
//			chicken(num.get(0), num.get(1),0);
/*
 * */
			
			int ans=0;
			for(int i=1;i<=n;i++) {
				sum=0;
				isVisited2 = new boolean[n+1];
				bfs(i);
//				System.out.println(sum+" : "+i);
				ans+=sum;
				
			}
			 
			if(min>ans*2) {
				min = ans*2;
				a1 = c1;
				a2 = c2;
			}
		
			return;
		}
		
		for(int i=idx;i<n;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				dfs(cnt+1,i+1);
				isVisited[i] = false;
			}
		}
	}
	
	//큐
	public static void bfs(int a) {
//		System.out.println("bfs 시작 "+a);
		if(a == c1 || a ==c2) {
			return;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i : list[a]) queue.add(i);
		isVisited2[a] = true;
		
		int len = queue.size();
		int next = 0;
		
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			int now = queue.poll();
			//c1이나 c2를 만나면 out
			if(now ==c1 || now ==c2) {
				sum++;
				break;
			}
			
			int ck=0;
			for(int n: list[now]) {
				if(!isVisited2[n]) {
					queue.add(n);
					ck++;
				}
			}
//			System.out.println("next / ck / len"+next+" "+ck+" "+len);
			//ck는 now번째 배열안에 있는 숫자개수(방문안한것만)
			next +=ck;
			//now 는 하나 빼야함 poll이니까
			len--;
			//한번에 넣은 숫자들, 즉 i번째 배열안의 숫자를 전부 계산하면+1일)
			if(len==0) {
				len = next;
				next=0;
				sum++;
			}
			
			isVisited2[now] = true;
//			System.out.println("막 "+queue);

		}
	}
	
	/*
	 * 치킨거리 구하기
	
	public static void chicken(int c1,int c2, int num) {
		if(num ==c1 || num==c2) {
			
			return;
		}
		
		for(int i=1;i<=n;i++) {
			isVisited2 = new boolean[n+1];
			isVisited2[i]= true;
			
		}
		
	}
	public static void dd(int idx,int cnt,int c1,int c2) {
		isVisited2[idx] = true;
		
		
		for(int a: list[idx]) {
			if(!isVisited[a]) {
				isVisited[a]= true;
				dd(a,cnt+1,c1,c2);
			}
			
		}
	} */
	


}
