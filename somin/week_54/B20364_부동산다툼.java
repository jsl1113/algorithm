import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20364_부동산다툼 {

	static int n,q;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		
		//아래에서부터 올라오기 1까지 올라올 때 true를 만나면 그 숫자를 저장
		//제일 먼저 만나는 숫자를 저장해야해서 1까지 모두 세야함
		for(int i=0;i<q;i++) {
			int num = Integer.parseInt(br.readLine());
			int meet = -1;
			//num = 6 이면 6 > 3 > 1
			for(int j = num; j>=1;j/=2) {
				if(visit[j]) {
					meet = j;
				}
			}
			visit[num] = true;
			if(meet == -1) {
				sb.append(0+"\n");
			}else {
				sb.append(meet+"\n");
			}
		}
		System.out.println(sb);		
	}
	

}
