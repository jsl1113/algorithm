import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2529_부등호 {

	static int k;
	static int [] arr;
	static int [] num;
	static boolean [] visit;
	
	static ArrayList<String> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		
		//1 : <  / 0: > 
		arr = new int[k];
		num = new int[k+1];
		visit = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<k;i++) {
			String s = st.nextToken();
			
			if(s.equals("<")) {
				arr[i] = 1;
			}else {
				arr[i] = 0;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<10;i++) {
			//0번째는 그냥 줌.
			num[0] = i;
			visit[i] = true;
			dfs(1);
			visit[i] = false;
		}
		
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}
	
	static void dfs(int cnt) {
		
		if(cnt == k+1) {
			String ans = "";
			for(int nn : num) {
				ans+=nn;
			}
			result.add(ans);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!visit[i]) { //안 쓴 숫자여야 함
				//조건에 맞아야 함. arr의 i-1번째와 num의 i번째.
				//전 숫자보다 크다 1 / 작다 0 
				int n = arr[cnt-1];
				
				if(n==1) {
					if(num[cnt-1] < i) {
						num[cnt] = i;
						visit[i] = true;
						dfs(cnt+1);
						visit[i] = false;
					}
				}else if(n==0){
					if(num[cnt-1] > i) {
						num[cnt] = i;
						visit[i] = true;
						dfs(cnt+1);
						visit[i] = false;
					}
				}
					
				
				
				
			}
			
		}
		
		
	}

}
