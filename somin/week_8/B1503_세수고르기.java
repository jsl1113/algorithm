package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1503_세수고르기 {

	static int n, m;
	static int[] s;
	static int[] number;
	
	static int min = Integer.MAX_VALUE;
	static int sum =1;
	static boolean status;
	
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		s = new int[m];
		
		number = new int[1003];
		for(int i=1;i<=1001;i++) number[i] = i;

//		System.out.println(Arrays.toString(number));
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<m;i++) {
			s[i] = Integer.parseInt(st.nextToken());
			number[s[i]] = -1;
		}
		Arrays.sort(s);
		
		for(int j=0;j<m;j++) {
			for(int i=0;i<=1000;i++) {
				if(s[j]==number[i]) {
					number[i] = -1;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(number));
		for(int i: number) {
			if(i!=-1) arr.add(i);
		}
		System.out.println(arr);
		
		
		// | N - xyz | = >
		// N <=1000  , s[i] <= 1000
		// 만약 N =1000 인데 s에서 높은 수를 다 쓰고 있다면.. 
		// number의 최대범위를 뭐로해야할까..? 1002? 
		for(int x=1;x<=1002;x++) {
			if(number[x]==-1) continue;
			for(int y=1;y<=1000;y++) {
				if(number[y]==-1) continue;
				for(int z =1;z<=1000;z++) {
					if(number[z]==-1) continue;
//					System.out.println(x+" "+y+" "+z);
					min = Math.min(min,Math.abs(n-(x*y*z)));
				}
			}
		}
		
		/*
		 * 배열로 하니까 맞아서 더 효율을 위해 어레이리스트 써봄  
		 * 틀렸습니다 나왔다. 이유가 뭘까??
		for(int x: arr) {
			for(int y : arr) {
				for(int z: arr) {
					min = Math.min(min, Math.abs(n-x*y*z));
				}
			}
		}
		
		*/
		
//		dfs(0);
		System.out.println(min);
	}
	public static void dfs(int cnt) {
		
		if(cnt ==3) {
//			System.out.println();
//			if(sum!=1 && Math.abs(n-sum)>min) {
//				System.out.println("넌 나가라: "+sum+" 총: "+Math.abs(n-sum));
//				status = true;
//				return;
//			}
			min = Math.min(min, Math.abs(n-sum));
//			System.out.println(sum+" ~ "+Math.abs(n-sum));
			
			return;
		}
		
		for(int i : arr) {
//			System.out.print(i+ " * ");
			sum*=i;
			dfs(cnt+1);
			sum /= i;
			
		}
		
	}

}
