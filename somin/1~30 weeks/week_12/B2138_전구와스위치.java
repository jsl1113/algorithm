package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * ���� dfs�� ���� �ʰ� ���� Ǫ�� ���� �𸣴� �ٺ��Դϴ�.
 * ---
 * 1���� Ű�� �����ϴ� �Ͱ� / 1�� Ű�� �ʰ� 2������ �����ϴ� ������ ������
 * �ؾ��ϴ� ������ �޿���.. �������ϴ�. �ణ dp���� ���⵵ �ϴ�.
 */
public class B2138_�����ͽ���ġ {

	static int n;
	static boolean [] isOn;
	static boolean [] isOn2;
	static boolean [] ans;
	static int num=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		isOn = new boolean[n]; 
		isOn2 = new boolean[n]; 
		ans = new boolean[n];
		
		String s = br.readLine();
		String s2 = br.readLine();
		for(int i=0;i<n;i++) {
			isOn[i] = s.charAt(i) !='0';
			isOn2[i] = s.charAt(i) !='0';
			ans[i] = s2.charAt(i) !='0';
			
		}
//		s = br.readLine();
		
		System.out.println(Arrays.toString(isOn));
		System.out.println(Arrays.toString(isOn2));
		System.out.println(Arrays.toString(ans));
		
		greedy(1, 0, isOn);
		greedy(1, 1, change(0, isOn2));
		
		System.out.println(num == Integer.MAX_VALUE ? -1:num);
		
	}
	
	public static void greedy(int idx, int cnt, boolean[] array) {
		
		if(idx == n) {
			if(array[idx-1] == ans[idx-1]) {
				num = Math.min(num, cnt);
			}
			return;
		}
		
		if(array[idx-1]!= ans[idx-1]) {
			greedy(idx+1, cnt+1, change(idx, array));
		}else {
			greedy(idx+1, cnt, array);
		}
		
	}
	
	public static boolean[] change(int now, boolean[] array) {
		if(now ==0) {
			array[now] = !array[now];
			array[now+1] = !array[now+1];
		}else if(now == n-1) {
			array[n-1] = !array[n-1];
			array[n-2] = !array[n-2];
		}else if(now>0 && now<n-1){
			array[now-1] = !array[now-1];
			array[now] = !array[now];
			array[now+1] = !array[now+1];
		}
		return array;
	}
	

	public static boolean[] change2(int idx, boolean[] array) {
		for(int i=idx-1;i<=idx+1;i++) {
			if(i>=0 && i<n) {
				array[i] = !array[i];
			}
		}
		return array;
	}


}
