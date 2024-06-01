import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1105_�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String L = st.nextToken();
		String R = st.nextToken();
		
		String [] arrR = R.split("");
		String [] arrL = L.split("");

		int [] numsR = Arrays.stream(arrR).mapToInt(Integer::parseInt).toArray();
		int [] numsL = Arrays.stream(arrL).mapToInt(Integer::parseInt).toArray();
		
		//���� ���� ��
		if(L.equals(R)) {
			int cnt=0;
			for(int ll : numsR) {
				if(ll==8) {
					cnt++;
				}
			}
			System.out.println(cnt);
			return;
		}
		
		//�ڸ� �� �ٸ��� 0 
		if(L.length()!=R.length()) {
			System.out.println(0);
			return;
		}
		
		//���̰� �߿��� ����
		int l = Integer.parseInt(L);
		int r = Integer.parseInt(R);
		
		int dist = r-l;
		int wRlen = R.length();
		int wDlen = Integer.toString(dist).length();
		
		int cnt = 0;
		int cnt2 = 0;
		
		//87878 87887 => 9���̰� �� �� �־ cnt�� �ΰ��� �Ἥ �ּڰ����� ���
		for(int i=0;i<wRlen-wDlen;i++) {
			if(numsR[i]==8) {
				cnt++;
			}
			if(numsL[i]==8) {
				cnt2++;
			}
		}
		
		System.out.println(Math.min(cnt, cnt2));
		
	}

}
