package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * 1시간 넘게 계속 생각해도 어떻게 할지 생각하다가 포기
 * 결론은 해시맵을 활용하면 쉽다.
 * 
 * 답: 
 *  <<char c='a'; 부분이 기깔나다. 진짜 이런 생각을 어떻게 하는거지 >>
 * mapping() 
 * 미리 입력값을 받아서 그 값이 key에 저장이 되어있지 않으면 저장시키는 방식 (value=a로)
 * 근데 다른 key값을 또 저장할거면 a를 value로 하면 안돼서 a++ = b이기 때문에 다음key는 b로 저장되는 방식
 *  
 * combi()
 * 에서는 n개중 2개의 숫자 고르기(중복X)을 해서 
 * 전체중에 몇쌍이 같은지 계산한다.
 * 
 * 정말 코드가 아름답다.....
 */
public class B1411_비슷한단어 {
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
		//n개중 2개의 숫자 고르기(중복X)
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