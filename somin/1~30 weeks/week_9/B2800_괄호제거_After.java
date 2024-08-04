package BOJ.data_structure;

/*
 * 못 푼 이유: 문제를 정확하게 안봐서 
 * "쌍이 되지 않는 괄호를 제거" 하면 안된다는 것을 제외하고 품 
 *  그래서 머리가 안굴러가고.. 어떻게 괄호를 쌍으로 묶어야하나 고민했지만..fail
 *  
 *  방법은 스택에 넣고 만약 뺄때 pop으로 왼쪽과 오른쪽을 모두 node로 저장가능
 *  그 뒤의 알고리즘은 거의 알고있었다.
 *  부분집합 구하는 거랑 등등... 
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
public class B2800_괄호제거_After {

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
