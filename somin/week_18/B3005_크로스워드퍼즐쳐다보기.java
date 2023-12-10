package BOJ.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B3005_크로스워드퍼즐쳐다보기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		ArrayList<String> words = new ArrayList<String>();
		
		Character [][] arr = new Character[r][c];
		
		for(int i=0;i<r;i++) {
			String s =br.readLine();
			String [] str = s.split("#");
			for(String ss : str) {
				if(ss.length()>1) {
					words.add(ss);						
				}
			}
			for(int j=0;j<c;j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for(int j=0;j<c;j++) {
			String s = "";
			for(int i=0;i<r;i++) {
				if(arr[i][j] == '#') {
					if(s.length()>1) {
						words.add(s);
					}
					s ="";
					continue;
				}
				s +=arr[i][j];
			}
			if(s.length()>1) {
				words.add(s);
			}
		}
		
		Collections.sort(words);
	
		System.out.println(words.get(0));
	}

}
