import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17615_볼모으기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		char[] arr = new char[n];
		int red=0;
		int blue=0;
		
		String s = br.readLine();
		for(int i=0;i<n;i++) {
			arr[i] = s.charAt(i);
			if(arr[i] =='R') red++;
			else
				blue++;
		}
		
		
		int ans = (red>blue)?blue:red;
		int cnt=0;
		//왼쪽으로 옮기기
		for(int i=0;i<n;i++) {
			if(arr[i]!=arr[0])break;
			cnt++;
		}
		System.out.println(cnt+" 왼족");
		if(arr[0]=='R') {
			ans = Math.min(ans, red-cnt);
		}else {
			ans = Math.min(ans, blue-cnt);
		}
		//오른쪽으로 옮기기
		cnt=0;
		for(int i=n-1;i>=0;i--) {
			if(arr[i]!=arr[n-1])break;
			cnt++;
		}
		System.out.println(cnt+" 오른");
		if(arr[n-1]=='R') {
			ans = Math.min(ans, red-cnt);
		}else {
			ans = Math.min(ans, blue-cnt);
		}
		
		System.out.println(ans);
		
	}

}
