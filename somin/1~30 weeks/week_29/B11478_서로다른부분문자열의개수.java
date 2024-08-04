import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B11478_서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		int len = s.length();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=1;i<=len;i++) {
			
			for(int j=0;j<len-(i-1);j++) {
				String ss = s.substring(j,j+i);
				map.put(ss, map.getOrDefault(ss, 0)+1);
				
			}
		}
		
		System.out.println(map.size());
	}

}
