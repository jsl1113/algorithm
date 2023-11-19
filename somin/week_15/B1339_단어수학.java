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
 * ���ĺ��� �ݺ��� �ȵȴٴ� �����Ͽ� �ϼ���������..������ �װ� �ƴϾ���
 * �� ���ĺ��� ��ġ��ŭ 1000 +10 +1 �̷������� ���� ���ؼ� �����صΰ�
 * �� map�� ������������ ������ �� cnt =9 ���� ���ϰ� cnt--; ���ָ� �ȴ�.
 * �Ӹ��� �� ���������ϰ� �������ϴ±���..  
 */
public class B1339_�ܾ���� {

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
