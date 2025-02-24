import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2217_ทฮวม {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int[] ans = new int[n];
		
		int max = 0;
		for(int i=0;i<n;i++) {
			ans[i] = (n-i)*arr[i];
			if(max<ans[i]) {
				max = ans[i];
			}
		}
		System.out.println(max);
		
	}
}
