import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413_�ܾ������2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		boolean flag = false; //true <   
		String now = "";
		for(int i=0;i<s.length();i++) {
			
			if(flag) { //tag�� ���������� ���� ������ ��� continue
				if(s.charAt(i)=='>') {
					flag = false;
					now+=s.charAt(i);
					sb.append(now);
					now="";
					continue;
				}else {
					now += s.charAt(i);
					continue;
				}
			}
			
			//������ ���ڸ� 
			if(i == s.length()-1) {
				now+=s.charAt(i);
				StringBuffer sf = new StringBuffer(now);
				String rev = sf.reverse().toString();
				
				sb.append(rev);
				continue;
			}
			
			//tag�ΰ� ?
			if(s.charAt(i)=='<') {
				
				//������ ������ ������ ������ �ֱ�
				if(now!="") {
					StringBuffer sf = new StringBuffer(now);
					String rev = sf.reverse().toString();
					
					sb.append(rev);
					now="";
				}
				now+= s.charAt(i);
				flag = true;
			}else if(s.charAt(i)== ' ') {
				StringBuffer sf = new StringBuffer(now);
				String rev = sf.reverse().toString();
				
				sb.append(rev+" ");
				
				now ="";
			}else { //�׳� ���ĺ��� ���
				now += s.charAt(i);
			}
			
		}
		
		System.out.println(sb);
		
		
		
//		String[] s = br.readLine().split(" ");
//		for(int i=0;i<s.length;i++) {
//			
//			//tag�ΰ�?
//			if(s[i].charAt(0) == '<') {
//				System.out.println(s[i]+" tag!");
//				sb.append(s[i]+" ");
//			}else {
//				//������
//				StringBuffer sb2 = new StringBuffer(s[i]);
//				String ss  = sb2.reverse().toString();
//				System.out.println(ss + "  reverse~");
//				sb.append(ss+" ");
//			}
//			
//		}

	}

}
