package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B14719_빗물 {

	static int h,w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[w];
		int ans =0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//왼 오 비교 : 각 최댓값을 구하고 그 중 최솟값에서 현재 값을 빼자
		
		for(int i=1;i<w-1;i++) {
			
			//left
			int left = 0;
			for(int j=0;j<i;j++) {
				left = Math.max(left, arr[j]);
			}
			
			int right = 0;
			for(int j=i+1;j<w;j++) {
				right = Math.max(arr[j], right);
			}
			
			if(arr[i] > Math.min(left, right)) continue;
			ans += Math.min(left, right) -arr[i];
			
		}
		
		System.out.println(ans);
		
		
		
	}

}
