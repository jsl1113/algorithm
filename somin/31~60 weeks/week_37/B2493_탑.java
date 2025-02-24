import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_ž {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		Stack<Top> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if(s.isEmpty()) {
				sb.append("0 ");
				s.add(new Top(i+1, now));
			}else {
				while(true) {
					//stack ����� ��
					if(s.isEmpty()) {
						sb.append("0 ");
						s.add(new Top(i+1, now));
						break;
					}
					
					Top top = s.peek();
					
					//���̶� ��
					if(top.val > now) {
						sb.append(top.index+" ");
						s.push(new Top(i+1, now));
						break;
					}else { //���� �� �۾� now����
						s.pop();
					}
				}
			}
			
		}
	

		System.out.println(sb);
		
	}
	static class Top{
		int index;
		int val;
		
		public Top(int index, int val) {
			this.index = index;
			this.val = val;
		}
		
	}
}
