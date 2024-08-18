import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
//union-find 방법인가 했는데 맞았다
public class B1922_네트워크연결 {

	static int n,m;
	static int[] parent;
	static List<Line> lst = new ArrayList<>();
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		for(int i=1;i<n;i++) {
			parent[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==b) continue;
			lst.add(new Line(a, b, c));
		}

		Collections.sort(lst, (o1,o2)-> o1.w-o2.w); //가중치 오름차순 정렬
		
		for(Line l : lst) {
			int a = l.a;
			int b = l.b;
			int w = l.w;
			
			//a의 부모값과 b의 부모값이 같으면 추가 안함
			if(find(a) == find(b) ) continue;
			
			union(a, b);
			ans += w;
		}
		System.out.println(ans);
	}

	static class Line{
		int a;
		int b;
		int w;
		
		public Line(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) parent[b] = a;
	}
	
}
