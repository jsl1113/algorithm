package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * �κ����� ������ dfs�ϴ� �� ��ﳵ���� 
 * �ε����� ��ȣ�� ��Ÿ���� �Ŷ� ���� �κ��� ���� ����ؼ� sum���� ��Ÿ���� �� �������ߴ�..��
 */
public class RV_B16637_��ȣ�߰��ϱ� {

	static int n;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> gi = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		for(int i=0;i<n;i+=2) {
			int m = str.charAt(i)-'0';
			num.add(m);
		}
		for(int i=1;i<n;i+=2) {
			gi.add(str.charAt(i));
		}
		
		dfs(0,num.get(0));
		System.out.println(max);
		
	}
	/*
	 * �κ����� ����
	 * gi �� ������� 4 
	 * �������� �켱������ �����ؼ� ��ȣ�� ���� �� (3+8)*7-9*2 �� ���� ��� �ȴ�..
	 */
	public static void dfs(int idx, int sum) {
		
		if(gi.size()<=idx) { //dfs(idx+2) ������ ������ �̻����� ���ǵα� 
			max = Math.max(max, sum);
			return;
		}
		//��ȣ ���� -> �ձ����� ������� ���� ��ȣ�� �����ϱ� ������ 
		//         ���⿡ sum�� ����. 
		int res = cal(sum, num.get(idx+1), idx);		
		dfs(idx+1,res);		
		
		//��ȣ ���� (idx�� ��ȣ�� ������-1���� Ŀ����)
		if(idx<gi.size()-1) {
			int right = cal(num.get(idx+1), num.get(idx+2), idx+1);
			int result = cal(sum, right, idx);
			dfs(idx+2,result);
		}
	}
	public static int cal(int a, int b, int idx) {
		switch (gi.get(idx)) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
			
		}
		return 0;
		
	}

}
