package programmers;

import java.util.HashMap;
import java.util.Map;
/*
 * �������� ��� ��ü���ڸ� ǥ���ұ� ���
 * �������.. ��ͷ� ��� ���ڸ� map�� �־��شٴ� ���� ������.
 * �ٵ� dp�ڵ�� �����ϴ� �ڵ尡 �� ����� �� ����....
 * 
 */
public class B42895_N����ǥ�� {

	public static void main(String[] args) {
//		int n = 5; int number = 12;
		int n = 2; int number = 11;

		Solution s = new Solution();
		System.out.println(s.solution(n, number));
	}
}

class Solution {
	static int MAX = 1111111111;
	public int solution(int N, int number) {
		int answer = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int cc=1;
		for(int i=N;i<=MAX;i = i*10+N) {
			map.put(i,cc);
			cc++;
		}
		
		rSol(N, 0, 0, map);
		
		
		return map.getOrDefault(number, -1);
	}
	
	public static void rSol(int N, int cnt, int current, Map<Integer, Integer> map) {
		if(cnt>8 || (cnt>0 && current==0)) return;
		
		map.put(current, Math.min(map.getOrDefault(current, cnt), cnt));
		
		int cc=1;
		for(int i=N;i<=MAX;i=i*10+N) {
			rSol(N, cnt+cc, current+i, map);
			rSol(N, cnt+cc, current-i, map);
			rSol(N, cnt+cc, current*i, map);
			rSol(N, cnt+cc, current/i, map);
			cc++;
		}
	}
}
