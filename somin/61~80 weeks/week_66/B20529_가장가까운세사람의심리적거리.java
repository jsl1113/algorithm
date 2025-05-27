import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20529_가장가까운세사람의심리적거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			String mbti[] = new String[n];
			for(int j=0;j<n;j++) {
				mbti[j] = st.nextToken();
			}
			
			if(n>32) {   //비둘기집 원리 
				System.out.println(0);
			}else {
				int min =Integer.MAX_VALUE;
				
				for(int j=0;j<n-2;j++) {
					for(int k=j+1;k<n-1;k++) {
						for(int l=k+1;l<n;l++) {
							int cnt=0;
							for(int p=0;p<4;p++) {
								if(mbti[j].charAt(p) !=mbti[k].charAt(p)) {
									cnt++;
								}
								if(mbti[j].charAt(p) !=mbti[l].charAt(p)) {
									cnt++;
								}
								if(mbti[l].charAt(p) !=mbti[k].charAt(p)) {
									cnt++;
								}
							}
							min = Math.min(cnt, min);
							if(min==0) {
								break;
							}
						}
					}
				}
				System.out.println(min);
			}
			
		}

	}

}
