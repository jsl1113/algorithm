package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 아직 Upper Bound와 Lower Bound를 모르겠다..
 * 공유기 사이 거리를 mid로 설정해서 사이 거리가 mid일때 공유기 개수를 카운트 해서 
 * 그에 따라 개수가 c보다 적으면 mid를 작게하고 
 * 개수가 c 이상이면 최소거리를 늘려줘서 
 * 조건을 충족하는 최대 거리를 알아낼 수 있었다..
 * 마지막에 s-1 해주는 것은 Upper Bound가 탐색 값을 초과하는 첫번째 값을 가리키기 때문이다.
 */
public class B2110_공유기설치 {

	static int n,c;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int s = 1;
		int e = arr[n-1] - arr[0] +1;
		
		while(s<e) {
			int mid = (s+e)/2;
			
			//mid 거리만큼 띄우고 설치한 개수가 c개 미만이면 mid거리는 작아져야함
			if(install(mid)<c) {
				e = mid;
			}
			else { //mid거리 만큼 띄우고 설치한 개수가 c이상이면 mid를 키워야함
				//최소거리가 가질 수 있는 최대거리를 찾아낸다..
				s = mid+1;
			}
		}
		
		System.out.println(s-1);
		
	}
	public static int install(int mid) {
		//1번째 집은 설치되었다
		int cnt=1;
		int lastLocate = arr[0];
		
		
		for(int i=1;i<n;i++) {
			int locate = arr[i];
			
			//그 전집과 현재 집의 거리 차이가 mid 이상일때만 cnt++하고 전집을 갱신
			if(locate- lastLocate >=mid) {
				cnt++;
				lastLocate = locate;
			}
			//집과 집사이 거리차이가 mid보다 작으면 공유기 설치조건이 안돼서 넘어가야함
		}
		
		return cnt;
	}

}
