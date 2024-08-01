import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1744_수묶기 {

	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		int minus = 0;
		int zero = 0;
		int plus = 0;  //1의 개수는 빼기 (그대신 sum++)
		int one = 0;
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]==0) {
				zero++;
			}
			if(arr[i]<0) minus++;
			if(arr[i]>0) {
				if(arr[i]==1) {
					one++;
					sum++;
					continue;
				}
				plus++;
			}
		}
		
		Arrays.sort(arr);
		
		//음수면 음수끼리 묶어야 이득
		//양수면 묶는게 이득인 경우 (1은 묶으면 손해) 1+3= 4 > 1*3=3
		
		if(minus == 1) {
			if(zero<=0) {
				sum += arr[0];
			}
		}else if(minus>=2) {
			for(int i=0;i<minus;i+=2) {
				if(i+1 >=minus) {
					if(zero>0) continue; //0있으면 음수는 없애
					sum+=arr[i];
					continue;
				}
				sum+=arr[i]*arr[i+1];
			}
			
		}
		int all = minus+zero+one;
		
		if(plus==1) {
			sum+=arr[n-1];
		}else if(plus>=2) {
			for(int i=n;i>all;i-=2) {
				if(i-1 <=all) {
					sum+=arr[i-1];
					continue;
				}
				sum += arr[i-1]*arr[i-2]; 
			}
		}
		
		System.out.println(sum);
		
	}

}
