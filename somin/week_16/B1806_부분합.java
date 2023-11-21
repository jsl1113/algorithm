import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806_부분합 {

	static int n,s;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		

		int s = 0;
		int e = 0;
		int cnt=0;
		int sum=arr[0];
		
		while(s<=e) {
			
			if(sum<s) {
				e +=1;
				if(arr.length<=e) {
					break;
				}
				sum+=arr[e];
			}else if(sum>s) {
				if(s == e) { // 원소 하나가 곧 sum
					e +=1;
					if(arr.length<=e) {
						break;
					}
					sum+=arr[e];
				}else {
					sum-=arr[s];
					s+=1;					
				}
			}else {
				cnt++;
				e +=1;
				if(arr.length<=e) {
					break;
				}
				sum+=arr[e];
			}
		}
		System.out.println(cnt);
		
	}
}
