import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B2776_¾Ï±â¿Õ {

	static int t,n,m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map.put(Integer.parseInt(st.nextToken()) , 1); 
			}
			
			m = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int now =Integer.parseInt(st.nextToken()); 
				if(map.containsKey(now)) {
					sb.append("1"+"\n");
				}else {
					sb.append("0"+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
