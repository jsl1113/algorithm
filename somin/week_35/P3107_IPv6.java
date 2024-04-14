import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P3107_IPv6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ip = br.readLine();
		
		
		//8��
		String [] s = ip.split(":");

		int what = 0;
		if(s.length>=9) { //::1:2:3:4:5:6:7 �� ��� 
			what = 9;
		}else {
			what = 8;
		}
		
		String [] ans = new String[what]; 
		
		for(int i=0;i<s.length;i++) {
			if(s[i].length()==0) {
				ans[i] = "0000";
			}else if(s[i].length()!=4) {
				int n = s[i].length();
				
				String now = "";
				
				for(int j=0;j<4-n;j++) {
					now +="0";
				}
				now += s[i];
				
				ans[i] = now;
			}else {
				ans[i] = s[i];
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<String> que = new LinkedList<String>();
		int nullnum = 0;
		
		for(String an : ans) {
			if(an==null) {
				nullnum++;
				continue;
			}
			que.add(an);
		}
		
		
		// �ǵڿ� ::���� ���
		if(ip.length()>=2) {
			int num = ip.length();
			
			if(ip.charAt(num-1)==':' && ip.charAt(num-2)==':') {
				
				for(int i=0;i<8;i++) {
					if(ans[i]==null) {
						sb.append("0000");
						if(i==7) continue;
						sb.append(":");
					}else {
						sb.append(ans[i]+":");
					}
				}
				System.out.println(sb);
				
				return;
			}
			
		}
		
		
		int colon = 0;
		boolean flag = false;
		while((nullnum!=0) && !que.isEmpty()) {
			String now = que.poll();
			
			if( !flag && now=="0000") {
				flag = true;
				sb.append(now+":");
				colon++;
				
				for(int i=0;i<nullnum;i++) {
					sb.append("0000");
					if(colon==7) continue;
					sb.append(":");
					colon++;
				}
			}else {
				sb.append(now);
				if(colon==7) continue;
				sb.append(":");
				colon++;
			}
		}
		
		//::1:2:3:4:5:6:7 �̸� null�� ����
		if(nullnum==0) {
			boolean flag2 = false;
			
			if(ans.length==8) {
				
				for(int i=0;i<8;i++) {
					sb.append(ans[i]);
					if(i==7)continue;
					sb.append(":");
				}
				
			}else { //ans length�� 9�̻��� ���
				
				for(int i=0;i<9;i++) {
					
					if(!flag2 && ans[i]=="0000") {
						flag2=true;
						continue;
					}
					sb.append(ans[i]);
					if(i==8)continue;
					sb.append(":");
				}
			}
			
		}
		
		System.out.println(sb);

		
	}

}
