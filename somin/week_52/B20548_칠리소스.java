import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* *함유량으로 몇번째로 큰 단계인지 맞추기
 *  함유량 1 = (7^0)*1 = 1단계
			함유량 2 = (7^0)*2 = 2단계
			함유량 7 = (7^1)*1 = 3단계
			함유량 8 = (7^0)*1 + (7^1)*1 = 4단계
			함유량 9 = (7^0)*2 + (7^1)*1 = 5단계
			함유량 14 = (7^1)*2 = 6단계
 */
// 나의 풀이 : 함유량이 나올 때까지 경우의 수 진행
// 			 그냥 최대 범위를 정해서 계속 계산할 생각만해서 답을 못 도출함
// 정답 : 7의 제곱을 최대 0~2까지 사용할 수 있다 = 3진수... 라는 생각을 어떻게 함?
//       풀이를 보고 답을 해석해서 품... 어렵다... 

public class B20548_칠리소스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long c = Long.parseLong(br.readLine());
		long ans = 0;
		int digit=1;
		/*
		 * c =15     ans += 15%7 * 1  (1 *1)
		 *  15/7 = 2 
		 */
		while(c>0) {
			ans  += (c % 7)*digit;
			c /=7;  
			digit *= 3;   
		}
		System.out.println(ans);
	}

}
