package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * 1�ð� �Ѱ� ��� �����ص� ��� ���� �����ϴٰ� ����
 * ����� �ؽø��� Ȱ���ϸ� ����.
 * 
 * ��: 
 *  <<char c='a'; �κ��� ��򳪴�. ��¥ �̷� ������ ��� �ϴ°��� >>
 * mapping() 
 * �̸� �Է°��� �޾Ƽ� �� ���� key�� ������ �Ǿ����� ������ �����Ű�� ��� (value=a��)
 * �ٵ� �ٸ� key���� �� �����ҰŸ� a�� value�� �ϸ� �ȵż� a++ = b�̱� ������ ����key�� b�� ����Ǵ� ���
 *  
 * combi()
 * ������ n���� 2���� ���� ����(�ߺ�X)�� �ؼ� 
 * ��ü�߿� ����� ������ ����Ѵ�.
 * 
 * ���� �ڵ尡 �Ƹ����.....
 */
public class B1411_����Ѵܾ� {
	static int answer;
	static int n;
	static int[] numbers;
	static String[] strs;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		numbers = new int[2];
		strs = new String[n];
		for(int i=0;i<n;i++) {
			strs[i] = mapping(bf.readLine());
		}
		
		answer = 0;
		combi(0,0);
		System.out.println(answer);
	}
	
	
	public static void combi(int start, int cnt) {
		if(cnt == 2) {
			if(strs[numbers[0]].equals(strs[numbers[1]])) {
				answer++;
			}
			return;
		}
		
		//0,1 / 0,2 / 0,3
		//n���� 2���� ���� ����(�ߺ�X)
		for(int i=start; i<n;i++) {
			numbers[cnt] = i;
			combi(i+1,cnt+1);
		}
	}
	
	
	public static String mapping(String str) {
		String answer = "";
		
		Map<Character,Character> map = new HashMap<>();
		char c='a';
		for(int i=0;i<str.length();i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), (char)(c++));
//				System.out.println(map+" / "+str+" /");
			}
			answer+=map.get(str.charAt(i));
//			System.out.println(map.get(str.charAt(i))+" "+answer);
		}
		
		return answer;
	}

}