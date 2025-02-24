import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//풀고 싶었던 방식이지만 이분탐색을 하는 과정을 못했다..
public class B3020_개똥벌레 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] odd = new int[n/2];  //홀수
		int[] even = new int[n/2]; //짝수
		
		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				even[i/2-1] = Integer.parseInt(br.readLine());
			}else {
				odd[i/2] = Integer.parseInt(br.readLine());
			}
		}
		
		Arrays.sort(odd);
		Arrays.sort(even);
		
		int min = n;
		int cnt = 0;
		
		for(int i=1; i<h+1; i++) {
			int crush =binarySearch(0, n/2, i, odd) 
					+ binarySearch(0, n/2, h-i+1, even);
			if(min == crush) {
				cnt++;
				continue;
			}
			if(min > crush) {
				min = crush;
				cnt=1;
			}
		}
		System.out.println(min +" " +cnt);
		
	}
	
	static int binarySearch(int left, int right, int h, int[] arr) {
		while(left<right) {
			int mid = (left+right)/2;
			
			//
			if(arr[mid] >= h) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		//right가 뿌셔지는 장애물 높이의 첫번째 값
        return arr.length-right;
	}

}
