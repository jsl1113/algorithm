import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2885_초콜릿식사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		/*
		 * k개의 정사각형을 만들어야함.
		 * 최소 막대기의 크기 ?
		 * 최소 몇번 잘라야 하나
		 * 
		 * ex) k = 6 
		 * 
		 * 1,2,4,8,16,32
		 * 2의 제곱이다. 
		 * 그럼 갯수가 이들 사이에 있으면
		 * 
		 */
		
		
		boolean flag = false;
		int min_choco = 0;
		//제곱 수와 같을 때는 굳이 안자르고  
		for(int i=0;i<Math.sqrt(1000000);i++) {
			if(Math.pow(2, i)>=k) {
				min_choco = (int) Math.pow(2, i);
				if(Math.pow(2, i)==k) {
					flag = true;
				}
				break;
			}
		}
		
		
		if(flag) {  //제곱 수와 같으면 바로 return
			System.out.println(min_choco+" "+0);
			return;
		}
		
		//min choco보다는 k가 작다. 그럼 몇번 자를지 세기
		int cnt=0;
		int len = min_choco;
		while(k>0) {  //k가 0이되면 종료
			if(k<len) {
				len /=2;
				cnt++;
			}else { //이제 k가 더 크거나 같다.
				k -= len;  //원하는 크기는 줄어든다.
			}
			
		}
		
		System.out.println(min_choco+" "+cnt);
		
		
	}

}
