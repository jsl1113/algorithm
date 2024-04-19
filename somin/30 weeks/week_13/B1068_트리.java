package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 먼저 한 부모에 3개이상의 자식노드가 있을 수 있다라고 
 * 생각 안하고 풀어서 처음에 틀렸다. 문제를 다 이해하고 푸니까
 * 반례를 통해서 생각보다 쉽게 답을 맞춤.
 */
public class B1068_트리 {

	static int n, r;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] ans;
	
	static int leaf=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n];
		ans = new ArrayList[n];
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<Integer>();
			ans[i] = new ArrayList<Integer>();
		}
		int top=0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1) {
				top = i;
				continue;
			}
			list[num].add(i);
			ans[num].add(i);
		}
		
		r = Integer.parseInt(br.readLine());
		
		dfs(r);
		
		//r 노드 삭제 (r의 자식 노드들은 dfs(r)로 삭제함
		for(int i=0;i<n;i++) {	
			for(int a : list[i]) {
				if(a==r) {
					ans[i].remove(Integer.valueOf(a));
				}
			}
		}
		//처음 부모노드(top)부터 깊이를 따라 leaf node를 카운트함
		depth(top);

		if(leaf ==0 ) { //처음 부모노드를 삭제한거라면 leaf node개수는 0개이고
			if(top != r) {//아니라면 딱 부모노드 하나만 남아있는 것이므로 1
				leaf =1;	
			}
		}
		System.out.println(leaf);
	}
	
	public static void dfs(int now) {
		
		for(int num : list[now]) {
			dfs(num);
			ans[now].remove(Integer.valueOf(num));
		}
	}
	
	public static void depth(int idx) {

		for(int num : ans[idx]) {
			depth(num);
			if(ans[num].size()==0) { 
				leaf++;
			}
		}

		
	}

}
