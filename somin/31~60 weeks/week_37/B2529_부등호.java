import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2529_�ε�ȣ {

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
			//0��°�� �׳� ��.
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
			if(!visit[i]) { //�� �� ���ڿ��� ��
				//���ǿ� �¾ƾ� ��. arr�� i-1��°�� num�� i��°.
				//�� ���ں��� ũ�� 1 / �۴� 0 
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
