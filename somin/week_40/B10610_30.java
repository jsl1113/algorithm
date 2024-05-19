import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10610_30 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		String [] arr = n.split("");
	
		int [] nums = new int[arr.length];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			nums[i] = Integer.parseInt(arr[i]);
			sum+=nums[i];
		}

		Arrays.sort(nums);
		
		//30의 배수의 특징 
		if(sum%3==0 && nums[0]==0) {
			for(int i=nums.length-1;i>=0;i--) {
				System.out.print(nums[i]);
			}
		}else
			System.out.println(-1);

	}

}
