package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� �� �θ� 3���̻��� �ڽĳ�尡 ���� �� �ִٶ�� 
 * ���� ���ϰ� Ǯ� ó���� Ʋ�ȴ�. ������ �� �����ϰ� Ǫ�ϱ�
 * �ݷʸ� ���ؼ� �������� ���� ���� ����.
 */
public class B1068_Ʈ�� {

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
		
		//r ��� ���� (r�� �ڽ� ������ dfs(r)�� ������
		for(int i=0;i<n;i++) {	
			for(int a : list[i]) {
				if(a==r) {
					ans[i].remove(Integer.valueOf(a));
				}
			}
		}
		//ó�� �θ���(top)���� ���̸� ���� leaf node�� ī��Ʈ��
		depth(top);

		if(leaf ==0 ) { //ó�� �θ��带 �����ѰŶ�� leaf node������ 0���̰�
			if(top != r) {//�ƴ϶�� �� �θ��� �ϳ��� �����ִ� ���̹Ƿ� 1
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
