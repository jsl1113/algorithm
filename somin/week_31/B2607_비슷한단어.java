import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 너무 복잡하게 푼 것 같다 
 * 키 포인트가 길이가 같을 때와 다를 때 나눔 
 *   -> 다를 때를 또 적을 때 많을 때로 나눴는데
 *      좀 과하게 나눈 느낌 ;
 */
public class B2607_비슷한단어 {

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
		
		//길이가 같을 때
		if(flen==next) {
			
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i]) {
					//다를 때 알파벳이 두개가 늘거나 줄었을 때
					if(Math.abs(first[i]-other[i]) >=2) {
						return false;
					}
					//다를 때 하나가 줄었을 때 
					cnt += Math.abs(first[i]-other[i]) ;
				}
			}
			if(cnt<=2) {
				return true;
			}
		}else if(flen>next) {
			//길이가 적을 때
			
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i] ) {
					if((first[i]-other[i])<0){
						//늘면 안돼 (무조건 하나를 뺏을 경우만)
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
			//길이가 많을 때
			for(int i=0;i<26;i++) {
				if(first[i]!=other[i]) {
					if((other[i]-first[i])<0) {
						//줄어들면 안돼 (바꿔도 안돼)
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
