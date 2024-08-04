package BOJ;
/*
 * DFS�� ��Ʈ��ŷ ����� �������� �ʾƼ� ���� ������ ���� Ǯ���� (�����ϱ�!)
 * Node Ŭ������ ��������� ���ߴ�.
 * house�� chicken�� ��ǥ(Node)�� ArrayList�� �־��ִ� ���
 * dfs() �Ű������� ġŲ���� ������ ���� cnt�� chickenList�� �ε����� idx �ΰ�
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686_ġŲ��� {

	static int N, M;
	static int [][] graph;
	static ArrayList<Node> chicken = new ArrayList<>();
	static ArrayList<Node> house = new ArrayList<>();
	static boolean[] chickenVisited;
	static int min = Integer.MAX_VALUE;
	
	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		 graph = new int [N][N];
		 
		 for(int i=0;i<N;i++) {
			 st = new StringTokenizer(bf.readLine());
			 for(int j=0;j<N;j++) {
				 graph[i][j] = Integer.parseInt(st.nextToken());
				 if(graph[i][j]==1) {
					 house.add(new Node(i, j));
				 }else if(graph[i][j]==2) {
					 chicken.add(new Node(i, j));
				 }
				 
			 }
		 }
		 
		 chickenVisited = new boolean[chicken.size()];
		 dfs(0, 0);
		 System.out.println(min);
				 

	}
	
	public static void dfs(int cnt, int idx) {
		if(cnt==M) {
			//ġŲ���� M���϶� �� ġŲ�Ÿ� = total
			int total=0;
			for(int i=0;i<house.size();i++) {
				int sum = Integer.MAX_VALUE; 
				for(int j=0;j<chicken.size();j++) {
					//i��° ���������� j��° ġŲ�� ������ �Ÿ� �� �ּҰ� = sum
					if(chickenVisited[j]) {
						int dis = Math.abs(house.get(i).x - chicken.get(j).x)+
								Math.abs(house.get(i).y -chicken.get(j).y);
						sum = Math.min(sum, dis);
					}
				}
				total +=sum;
			}
			min = Math.min(total, min);
			return;
		}
		
		for(int i=idx;i<chicken.size();i++) {
			if(!chickenVisited[i]){
				chickenVisited[i]= true;
				dfs(cnt+1, i+1);
				chickenVisited[i] = false;
			}
		}
	}
	
}
