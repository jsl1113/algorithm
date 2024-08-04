import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4375_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";
		StringBuilder sb = new StringBuilder();
		while((input = br.readLine())!=null && !input.equals("")) {
			int now = Integer.parseInt(input);
			long num = 1;
			int cnt = 1;
			
			while(true) {
				//1, 11, 111, 1111, 등으로 나누어지는지
				if( (num %= now) == 0) {
					sb.append(cnt+"\n");
					break;
				}
				num = num*10 +1;
				cnt++;
			}
		}
		System.out.println(sb);
		
	}

}
