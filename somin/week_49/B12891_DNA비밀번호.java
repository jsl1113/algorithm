import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
// ó���� if������ acgt ���� �����µ� 
// ������ �����ؼ� ���ϱ� �ڵ尡 ª������.
public class B12891_DNA��й�ȣ {

	static int s,p;
	static HashMap<Character, Integer> map = new HashMap<>();
	static int[] num2 = new int[4];
	static int[] tmp = new int[4];
	static int ans=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//A C G T
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		//map�� ���ĺ� �� 0123 ���� 
		map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T',3);
		
		String word = br.readLine();
		int[] num = new int[4];   //�Է¹��� ���ڿ��� ACGT ���� �����
		
		for(int i=0;i<s;i++) {
			int nn = map.get(word.charAt(i));
			num[nn]++;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++) {
			num2[i] = Integer.parseInt(st.nextToken());
			if(num[i]<num2[i]) { // ���ʿ� �ּ� �������� ��ü������ ������ 0���
				System.out.println(0);
                return;
			}
		}
		
		//0~p-1 ������ �� ������ ��
		for(int i=0;i<p;i++) {
			int nn = map.get(word.charAt(i));
			tmp[nn]++;
		}
		
		if(check(tmp)) { //0��°�� �����ϴ��� üũ
			ans++;
		}
		
		//1��°���� s-p��°���� �����ϴ� ����		
		/*  4 2
			GATA
			1 0 0 1
			#0 :GA  #1:(-G)A(+T) #2:(-A)T(+A)
		 */
		for(int i=p;i<s;i++) { 
			int pre = map.get(word.charAt(i-p));
			int add = map.get(word.charAt(i));
			tmp[pre]--;
			tmp[add]++;
			
			if(check(tmp)) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
		
	}
	static boolean check(int[] tmp) {
		
		for(int i=0;i<4;i++) {
			if(tmp[i]<num2[i]) {
				return false;
			}
		}
		return true;
	}

}
