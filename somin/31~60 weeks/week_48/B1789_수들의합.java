import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 최소의 자연수로 합을 만들다가 s보다 커지면 
 * 지금 n개의 자연수보다 1개 뺀 개수로 s를 만들 수 있다는 뜻이다.
 * 
 * 11) 1+2+3+4+5 = 15 그럼 자연수 5개로는 못만들고 4개로 만들 수 있음
 *                 (15-11)인 4를 빼면 된다. 
 *  딱 떨어지는 경우인 15) (15+6)이 되는데 
 *                 이때 num-1이 정답이기때문에 괜찮다.
 */
public class B1789_수들의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long s = Long.parseLong(br.readLine());
		
		
		int num = 1;
		long sum = 0; //long 주의
		
		while(true) {
			sum += num;
			
			if(sum > s) {
				break;
			} 
			
			num++;
		}
		System.out.println(num-1);

	}

}
