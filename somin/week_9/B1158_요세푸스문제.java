package BOJ.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 자료구조 큐 문제
 */
public class B1158_요세푸스문제 {

	static int n,k;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt=0;
		for(int i=0;i<n;i++) {
			cnt++;
			if(cnt ==k) {
				cnt=0;
				sb.append(i+1+", ");
			}else {
				queue.add(i+1);
			}
			
		}
//		System.out.println(cnt+" "+queue);
		
		while(!queue.isEmpty()) {
			cnt++;
			int now = queue.poll();
			
			if(cnt == k) {
				cnt=0;
				sb.append(now+", ");
			}
			else {
				queue.add(now);
			}
//			System.out.println(queue);
		}
		
		
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		System.out.println(sb);
	}

}
