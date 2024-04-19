package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * ���� �Ϸ��� �ߴ� ���: ������ ���� / 2 �� ������ ��ȣ�� ������ �������ְ�
 * ��ȣ�� 1~ �ִ��ȣ���� ���� ��� ���� ���� �����ϱ�..
 * dfs��..?
 */
public class B16637_��ȣ�߰��ϱ� {

	static int n,nlen;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<String> cal = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n =Integer.parseInt(br.readLine());
		
		
		
		String s = br.readLine();
		
		for(int i =0;i<n;i+=2) {
			num.add(s.charAt(i) -'0');
		}
		
		for(int i=1;i<n;i+=2) {
			String ss = Character.toString(s.charAt(i));
			cal.add(ss);
		}
		nlen = num.size();
	
		
		dfs(0,num.get(0));
		System.out.println(max);
	}
	public static int calculate(int a, int b, int idx) {
		switch (cal.get(idx)) {
		case "+":
			return a+b;
		case "-":
			return a-b;
		case "*":
			return a*b;
		}
		return 1;
	}
	
	public static void dfs(int idx, int sum) {
		if(idx >= cal.size()) {
			
			max = Math.max(max, sum);
			return;
		}
		//��ȣ ������
		int one = calculate(sum, num.get(idx+1), idx);
		
		dfs(idx+1, one);
		
		//��ȣ ġ�� ����
		if(idx + 1<cal.size()) {
			
			int two = calculate(num.get(idx+1), num.get(idx+2), idx+1);
			int res = calculate(sum, two, idx);
			
			dfs(idx+2, res);
			
		}
		
	}
	

}
