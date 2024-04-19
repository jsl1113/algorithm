package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 알파벳과 숫자는 char리스트에 넣는 방법
 * 그 배열을 복제해서 옮기고 만약 체스판을 벗어나지 않으면 원래 배열로 지정
 */
public class B1063_킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char [] king = st.nextToken().toCharArray();
		char [] stone = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());
		
		System.out.println(Arrays.toString(king));
		System.out.println(Arrays.toString(stone));
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			
			char [] k = king.clone();	
			sol(s, k);
			if(!isOn(k))continue;
			
			char [] ss = stone.clone();
			if(Arrays.equals(k, ss)) {
				sol(s,ss);
				if(!isOn(ss)) continue;
			}
			
			king = k;
			stone = ss;
		}
		
		System.out.println(king);
		System.out.println(stone);
		

	}
	static boolean isOn(char[] arr) {
		if(arr[0]<'A' || arr[0]>'H'||arr[1]<'1'||arr[1]>'8')
			return false;
		else
			return true;
	}

	static void sol(String s, char[] arr) {
		switch (s) {
		case "R":
			arr[0]++;
			break;
		case "L":
			arr[0]--;
			break;
		case "B":
			arr[1]--;
			break;
		case "T":
			arr[1]++;
			break;
		case "RT":
			arr[0]++; arr[1]++;
			break;
		case "LT":
			arr[0]--; arr[1]++;
			break;
		case "RB":
			arr[0]++; arr[1]--;
			break; 
		case "LB":
			arr[0]--; arr[1]--;
			break;
			
		}
		
	}
}
