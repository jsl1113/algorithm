import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//기울기를 사용하는 문제인지 파악하는데 시간이 걸렸다. 너무 시간 많이씀;
public class B1027_고층건물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		
		int[] arr=new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n==1) {
			System.out.println(0);
			return;
		}else if(n==2) {
			System.out.println(1);
			return;
		}
		
		int ans =0;
		
		double tmp= slope(1, 2, arr[1], arr[2]);
		int cnt=1;
		for(int i=3;i<=n;i++) {
			double now = slope(1, i, arr[1], arr[i]);
			if(tmp< now) {
				tmp = now;
				cnt++;
			}
		}
		ans =Math.max(ans, cnt);
		
		tmp= slope(n, n-1, arr[n], arr[n-1]);
		cnt=1;
		for(int i=n-2;i>=1;i--) {
			double now = slope(n, i, arr[n], arr[i]);
			if(tmp>now) {
				tmp = now;
				cnt++;
			}
		}
		ans =Math.max(ans, cnt);
		
		for(int i=2;i<=n-1;i++) {
			int now=i;
			double left = slope(i, i-1, arr[i], arr[i-1]);
			double right = slope(i, i+1, arr[i], arr[i+1]);
			int lcnt =1;
			int rcnt =1;
			
			for(int l=now-2;l>=1;l--) {
				double degree = slope(i, l, arr[i], arr[l]);
				if(left > degree ) {
					left = degree;
					lcnt++;
				}
			}
			
			for(int r=now+2;r<=n;r++) {
				double degree = slope(i, r, arr[i], arr[r]);
				if(right < degree) {
					right = degree;
					rcnt++;
				}
			}
			
			ans = Math.max(ans, rcnt+lcnt);
		}
		
		System.out.println(ans);
	}
	
	static double slope(int x1, int x2, int y1, int y2) {
		double x = x2 - x1;
		double y = y2 - y1;
		
		return y / x;
	}

}
