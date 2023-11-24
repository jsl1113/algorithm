import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 투 포인터
 * a배열안의 어느 수가 m보다 클 수 있다는 사실을 캐치하지 못해서 틀림
 * 반례 최고 
 * 4 1 
 * 1 2 3 1
 */
public class B2003_수들의합2 {

	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
//		System.out.println(Arrays.toString(arr));
		
		int s = 0;
		int e = 0;
		int cnt=0;
		int sum=arr[0];
		
		while(s<=e) {
			
			if(sum<m) {
				e +=1;
				if(arr.length<=e) {
					break;
				}
				sum+=arr[e];
			}else if(sum>m) {
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
