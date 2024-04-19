package BOJ.data_structure;

/*
 * �� Ǭ ����: ������ ��Ȯ�ϰ� �Ⱥ��� 
 * "���� ���� �ʴ� ��ȣ�� ����" �ϸ� �ȵȴٴ� ���� �����ϰ� ǰ 
 *  �׷��� �Ӹ��� �ȱ�������.. ��� ��ȣ�� ������ ������ϳ� ���������..fail
 *  
 *  ����� ���ÿ� �ְ� ���� ���� pop���� ���ʰ� �������� ��� node�� ���尡��
 *  �� ���� �˰����� ���� �˰��־���.
 *  �κ����� ���ϴ� �Ŷ� ���... 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Node{
	int l,r;
	public Node(int l,int r) {
		this.l=l;
		this.r=r;
	}
}
public class B2800_��ȣ����_After {

	static String s;
	
	static ArrayList<Node> nodes;
	
	
	static int len;

	static boolean [] isVisited;
	
	
	static ArrayList<String> ans= new ArrayList<>();

	static ArrayList<Integer>[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		
		nodes = new ArrayList<Node>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '(') {
				stack.add(i);
			}
			else if(s.charAt(i)==')') {
				nodes.add(new Node(stack.pop(), i));
			}
		}
		
		isVisited = new boolean[nodes.size()];
	
		len = nodes.size();
		solve(0);
		
		Collections.sort(ans);
		for(String s: ans) {
			System.out.println(s);
		}
		
	}
	
	public static void solve(int idx) {
		
		if(idx == len) {
			StringBuilder sb = new StringBuilder();
			boolean [] check = new boolean[s.length()];
			
			for(int i=0;i<len;i++) {
				if(isVisited[i]) {
					check[nodes.get(i).r] = true;
					check[nodes.get(i).l] = true;
				}
			}
			for(int i=0;i<s.length();i++) {
				if(!check[i]) sb.append(s.charAt(i));
			}
			if(sb.length() !=s.length()) {
				if(!ans.contains(sb.toString())) {
					ans.add(sb.toString());
				}
			}
			return;
		}
		
		isVisited[idx] = true;
		solve(idx+1);
		
		isVisited[idx] = false;
		solve(idx+1);
		
	}
	


}
