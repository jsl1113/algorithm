import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B5052_전화번호목록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<String> lst = new ArrayList<String>();
			for(int j=0;j<n;j++) {
				String s = br.readLine();
				lst.add(s);
			}
		
			Collections.sort(lst);
			
			String prev =lst.get(0);
			boolean flag = false;
			
			for(int j=1;j<n;j++) {
				int fin = prev.length();
				int now = lst.get(j).length();
				if(fin<now) {
					String nowS = lst.get(j).substring(0, fin);
					if(nowS.equals(prev)) {
						sb.append("NO"+ "\n");
						flag = true;
						break;
					}
				}
				prev = lst.get(j);
			}
			
			if(!flag) {
				sb.append("YES"+ "\n");
			}
			
		}
		System.out.println(sb);
	}


}
