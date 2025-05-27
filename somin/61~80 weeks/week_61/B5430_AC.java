import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
// 1. deque ���� => reverse�� ��¥ �������� �ȵȴ�. flag�� reverse ǥ�� 
// 2. �������� reverse�� flag�� �Ǵ��ϱ�
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
			
			boolean flag = false;   //false�� ���� ���� true�� ������
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
							error = true; //���� �� ���� ���� error
							break;
						}else {
							if(flag) { // �Ųٷ� �� ��
								arrque.removeLast();
							}else { //�Ǿ�
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
				
				if(flag) { // ������
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
