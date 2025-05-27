import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
// 1. deque 쓰기 => reverse를 진짜 뒤집으면 안된다. flag로 reverse 표현 
// 2. 마지막에 reverse를 flag로 판단하기
public class B5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			String[] s = br.readLine().split("");
			Deque<Integer> arrque = new LinkedList<Integer>();
			
			int n = Integer.parseInt(br.readLine());
			String ns = br.readLine();
			
			boolean flag = false;   //false면 원래 방향 true면 뒤집기
			boolean error = false;
			if(n == 0) {
				for(String ss : s) {
					if(ss.equals("D")) {
						error = true;
						break;
					}
				}
			}else {
				ns = ns.substring(1, ns.length()-1);
				String[] nums = ns.split(",");
				
				for(String num : nums) {
					arrque.add(Integer.parseInt(num));
				}
				
				for(String ss: s) {
					if(ss.equals("R")) {
						flag = !flag;
					}else { //D
						if(arrque.isEmpty()) {
							error = true; //삭제 할 것이 없다 error
							break;
						}else {
							if(flag) { // 거꾸로 맨 뒤
								arrque.removeLast();
							}else { //맨앞
								arrque.removeFirst();
							}
						}
					}
				}
			}
			
			
			if(error) {
				sb.append("error");
				sb.append("\n");
			}else {
				sb.append("[");
				
				if(flag) { // 뒤집기
					if(!arrque.isEmpty()) {
						sb.append(arrque.pollLast());
						//
						while(!arrque.isEmpty()) {
							sb.append(","+arrque.pollLast());
						}
					}
					
				}else {
					if(!arrque.isEmpty()) {
						sb.append(arrque.pollFirst());
						//
						while(!arrque.isEmpty()) {
							sb.append(","+arrque.pollFirst());
						}
					}
					
				}
				sb.append("]");
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
}
