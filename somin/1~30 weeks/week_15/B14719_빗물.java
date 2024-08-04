package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 너의 init을 따라해봤어 ^_^
/*
 * 자꾸 현재에서 그전값에 비해서 큰지 작은지 비교로 하려니까 모르겠고 오른쪽 비교는 어떻게 하지? 했다
 * --
 * 현재위치는 1~w-1까지 (0과 w는 물이 채워질 수 없다)
 * 현재 위치 기준으로 왼쪽 오른쪽으로 나눠서 왼쪽과 오른쪽의 최댓값을 구한다.
 * 그 둘 중 작은 값에서 현재 높이를 뺀다 (근데 뺀 값이 음수이면 0)
 * 그 값을 합해나가면 된다 
 */
public class B14719_빗물 {

	static int h,w;
	static int[] list;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		list = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<w;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	static void sol() {
		for(int i=1;i<w-1;i++) {
			int left=0; int right=0;
			for(int j=0;j<i;j++) { //왼쪽부터 i까지 최댓값
				left = Math.max(left, list[j]);
			}
			for(int j=i+1;j<w;j++) { //i+1부터 끝까지 최댓값
				right = Math.max(right, list[j]);
			}
			//왼 오 중 더 작은 블록 크기만큼 물이 찬다
			int t = ( Math.min(left, right) - list[i]<0) ? 0 :Math.min(left, right) - list[i];
			ans+=t;
			
		}
		System.out.println(ans);
	}
}
