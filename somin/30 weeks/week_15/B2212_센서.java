package BOJ.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//���� �������� �����ϱⰡ ������� �����ɷȴ� ���� (���� Ǯ� ����)
public class B2212_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] subt =new int[n-1];
		for(int i=1;i<n;i++	) {
			subt[i-1] = arr[i] - arr[i-1];
		}
		Arrays.sort(subt);
		int sum=0;
		for(int i=0;i<n-1-(k-1);i++) {
			sum+=subt[i];
		}
		System.out.println(sum);
		
	}

}
