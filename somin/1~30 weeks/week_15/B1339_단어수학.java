package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
/*
 * 알파벳이 반복이 안된다는 가정하에 완성시켰지만..문제는 그게 아니었음
 * 각 알파벳의 위치만큼 1000 +10 +1 이런식으로 값을 합해서 저장해두고
 * 그 map을 내림차순으로 정렬한 후 cnt =9 부터 곱하고 cnt--; 해주면 된다.
 * 머리를 더 말랑말랑하게 굴려야하는구나..  
 */
public class B1339_단어수학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		ArrayList<Str> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<s.length();j++) {
				Character c = s.charAt(j);
				if(!map.containsKey(c)) {
					map.put(c, (int) Math.pow(10, (s.length()-j-1)));
			
				}else {
					int pri =map.get(c);
					map.put(c, pri+(int) Math.pow(10, (s.length()-j-1)));
			
				}
			}
			
		}
	
		for(Entry<Character, Integer> en : map.entrySet()) {
			list.add(new Str(en.getKey(),en.getValue()));
		}
		Collections.sort(list,(a,b)-> b.num-a.num);
		int cnt=10;
		int sum=0;
		for(Str ss: list) {
			sum+=--cnt*ss.num;
		}
		System.out.println(sum);
		
	}

	static class Str{
		Character s;
		int num;
		Str(Character s, int len){
			this.s=s;
			this.num=len;
		}
		Str(int len){
			this.num=len;
		}
	}
}
