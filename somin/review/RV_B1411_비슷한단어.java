package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RV_B1411_비슷한단어 {

	static int n;
	static String[] str;
	static int[] num;
	static int ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		str =new String[n];
		num = new int[2];
		for(int i=0;i<n;i++) {
			str[i] = make(br.readLine());
			System.out.println(str[i]);
		}
		check(0,0);
		System.out.println(ans);
		
	}
	//모든 2개씩 부분집합 경우의 수를 체크 (0,1 /0,2/ 0,3/0,4 ..)
	public static void check(int idx, int cnt) {
		if(cnt==2) {
			if(str[num[0]].equals(str[num[1]])) ans++;
			return;
		}
		
		for(int i=idx;i<n;i++) {
			num[cnt] = i;
			check(i+1, cnt+1);
		}
		
	}
	
	public static String make(String str) {
		
		//입력을 받고 해쉬맵으로 등록할거다.
		Map<Character, Character> map = new HashMap<Character, Character>();
		char val = 'a';
		String ans="";
		for(int i=0;i<str.length();i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), val++);
			}
			ans += map.get(str.charAt(i));
		}
		
		return ans;
	}

}
