import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B21318_피아노체조 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] mistake = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i-1]>arr[i]) {
				mistake[i] = mistake[i-1]+1;
			}else {
				mistake[i] = mistake[i-1];
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int result = mistake[y] - mistake[x];
			
			System.out.println(result);			
			
		}
		
		
	}

}
