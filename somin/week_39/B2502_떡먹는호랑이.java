import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2502_¶±¸Ô´ÂÈ£¶ûÀÌ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Func [] f = new Func[d+1];
		
		f[1] = new Func(1, 0);
		f[2] = new Func(0, 1);
		
		for(int i=3;i<=d;i++) {
			int a = f[i-1].a  + f[i-2].a;
			int b = f[i-1].b  + f[i-2].b;
			
			f[i] = new Func(a, b);
		}
		
		int[] ans = solve(f[d].a, f[d].b, k);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}
	
	static int[] solve(int a, int b, int k) {
		
		int cnt=1;
		int[] ans = new int[2];
		while(true) {
			
			if( (k-(a*cnt))%b==0 ) {
				
				ans[0] = cnt;
				ans[1] = (k-(a*cnt))/b;
				
				if(ans[0]<=ans[1]) {
					return ans;
				}
			}
			cnt++;
		}
		
	}
	
	static class Func{
		int a;
		int b;
		public Func(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
