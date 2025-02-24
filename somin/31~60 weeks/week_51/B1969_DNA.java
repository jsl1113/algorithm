import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1969_DNA {

	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		String[] str = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i] = br.readLine();
		}
		int sum = 0;
		String ans ="";
		
		for(int i=0;i<m;i++) {
			int cnt[] = new int[4]; // A T G C
			for(int j=0;j<n;j++) {
				
				switch (str[j].charAt(i)) {
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
				}
			}
			
			int idx = 0;
			int max = 0;
			for(int k=0;k<4;k++) {
				if(cnt[k]>max) {
					max = cnt[k];
					idx = k;
				}
			}
			
			sum += n-max;
			
			switch (idx) {
			case 0:
				ans += "A";
				break;
			case 1:
				ans += "C";
				break;
			case 2:
				ans += "G";
				break;
			case 3:
				ans += "T";
				break;
			}
			
		}
		
		System.out.println(ans);
		System.out.println(sum);
		
		
	}

}
