import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * �ʹ� �����ϰ� Ǭ �� ���� 
 * Ű ����Ʈ�� ���̰� ���� ���� �ٸ� �� ���� 
 *   -> �ٸ� ���� �� ���� �� ���� ���� �����µ�
 *      �� ���ϰ� ���� ���� ;
 */
public class B2607_����Ѵܾ� {

	static int flen=0;
	static int next=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] alpa = new int[26];
		
		int ans = 0;
		
		String [] str = (br.readLine()).split("");
		for(String s : str) {
			alpa[s.charAt(0)-'A']++;
		}
		flen = str.length;

		for(int i=0;i<n-1;i++) {
			String ss = br.readLine();
			next = ss.length();
			
			String [] list = ss.split("");
			
			int[] other = new int[26];
			for(String s : list) {
				other[s.charAt(0)-'A']++;
			}
			
			if(similar(alpa, other)) {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static boolean similar(int[] first, int[] other) {
		
		int cnt=0;
		
		//���̰� ���� ��
		if(flen==next) {
			
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i]) {
					//�ٸ� �� ���ĺ��� �ΰ��� �ðų� �پ��� ��
					if(Math.abs(first[i]-other[i]) >=2) {
						return false;
					}
					//�ٸ� �� �ϳ��� �پ��� �� 
					cnt += Math.abs(first[i]-other[i]) ;
				}
			}
			if(cnt<=2) {
				return true;
			}
		}else if(flen>next) {
			//���̰� ���� ��
			
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i] ) {
					if((first[i]-other[i])<0){
						//�ø� �ȵ� (������ �ϳ��� ���� ��츸)
						return false;
					}
					if(Math.abs(first[i]-other[i]) >=2) {
						return false;
					}
					cnt += first[i]-other[i];
				}
				
			}
            if(Math.abs(cnt)<2) {
			    return true;
		    }
		}else if(flen<next) {
			//���̰� ���� ��
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i]) {
					if((other[i]-first[i])<0) {
						//�پ��� �ȵ� (�ٲ㵵 �ȵ�)
						return false;
					}
					if(Math.abs(first[i]-other[i]) >=2) {
						return false;
					}
					cnt += first[i]-other[i];
				}
				
			}
            if(Math.abs(cnt)<2) {
			    return true;
		    }
		}
		
		return false;
	}

}
