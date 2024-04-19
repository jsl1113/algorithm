package BOJ.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자 {

	static int [] city;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		city = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			city[i]=i;
		}
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++) {
				int connect = Integer.parseInt(st.nextToken());
			
				if(connect==1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int num=find(Integer.parseInt(st.nextToken()));
		
		for(int i=1;i<m;i++) {
			int now = find(Integer.parseInt(st.nextToken()));
			if(num != now) {
				System.out.println("NO");
				break;
			}
			if(i==m-1) System.out.println("YES");
		}
		
	}
	public static void union(int a , int b) {
		int A = find(a);
		int B = find(b);
		
		if(A!=B) {
			city[B] = A;
		}
	}
	public static int find(int a) {
		if(city[a] == a)
			return a;
		return city[a] = find(city[a]);
	}

}
