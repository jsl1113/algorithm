import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1205_등수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int taesue = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if(n==0) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//태수의 점수가 들어갈 수 있냐
		if(n == p && arr[n-1] >= taesue) {
			System.out.println("-1");
			return;
		}
		
		//리스트 p갯수는 n보다 크거나 같다
		
		int rank = 1;
		for(int i=0;i<arr.length;i++) {
			if(taesue < arr[i]) rank++;
			else {
				break;
			}
		}
		System.out.println(rank);
		
		
	}
	
}
