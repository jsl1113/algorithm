import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_트리순회 {

	static int n;
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		tree = new int[n][2];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//본인 , 왼쪽, 오른쪽
			int now = st.nextToken().charAt(0)-'A';
			int left = st.nextToken().charAt(0)-'A';
			int right = st.nextToken().charAt(0)-'A';
			
			tree[now][0] = (left == -19)? -1:left;
			tree[now][1] = (right == -19)? -1:right;
			
		}
		//전위순회
		preOrder(0);
		sb.append("\n");
		//중위순회
		inOrder(0);
		sb.append("\n");
		//후위순회
		postOrder(0);
		sb.append("\n");
		
		System.out.println(sb);
	}
	public static void preOrder(int num) {
		if(num==-1) return;
		sb.append((char)(num +'A'));
		preOrder(tree[num][0]);
		preOrder(tree[num][1]);
	}
	public static void inOrder(int num) {
		if(num==-1) return;
		inOrder(tree[num][0]);
		sb.append((char)(num +'A'));
		inOrder(tree[num][1]);
	}
	public static void postOrder(int num) {
		if(num==-1) return;
		postOrder(tree[num][0]);
		postOrder(tree[num][1]);
		sb.append((char)(num +'A'));
	}

}
