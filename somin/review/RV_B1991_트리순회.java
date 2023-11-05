package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B1991_트리순회 {

	static int[][]tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tree = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = (st.nextToken().charAt(0)-'A');
			int b = st.nextToken().charAt(0)-'A';
			int c = st.nextToken().charAt(0)-'A';
			
			tree[a][0]=b;
			tree[a][1]=c;
			
		}
		
		prior(0);
		System.out.println(sb);
		sb = new StringBuilder();
		middle(0);
		System.out.println(sb);
		sb = new StringBuilder();
		after(0);
		System.out.println(sb);
	}
	public static void prior(int num) {
		if(num ==-19)
			return;
		sb.append((char)(num+'A') );
		prior(tree[num][0]);
		prior(tree[num][1]);
	}

	public static void middle(int num) {
		if(num ==-19)
			return;
		middle(tree[num][0]);
		sb.append((char)(num+'A') );
		middle(tree[num][1]);
	}
	public static void after(int num) {
		if(num ==-19)
			return;
		after(tree[num][0]);
		after(tree[num][1]);
		sb.append((char)(num+'A') );
	}
}
