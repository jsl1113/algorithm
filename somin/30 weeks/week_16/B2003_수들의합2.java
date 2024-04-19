import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �� ������
 * a�迭���� ��� ���� m���� Ŭ �� �ִٴ� ����� ĳġ���� ���ؼ� Ʋ��
 * �ݷ� �ְ� 
 * 4 1 
 * 1 2 3 1
 */
public class B2003_��������2 {

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
				if(s == e) { // ���� �ϳ��� �� sum
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
