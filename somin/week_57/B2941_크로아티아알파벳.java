import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ss = br.readLine();
		
		if(ss.contains("c=")) {
			ss = ss.replaceAll("c=", " ");
		}
		if(ss.contains("c-")) {
			ss = ss.replaceAll("c-", " ");
		}
		if(ss.contains("dz=")) {
			ss = ss.replaceAll("dz=", " ");
		}
		if(ss.contains("d-")) {
			ss = ss.replaceAll("d-", " ");
		}
		if(ss.contains("lj")) {
			ss = ss.replaceAll("lj", " ");
		}
		if(ss.contains("nj")) {
			ss = ss.replaceAll("nj", " ");
		}
		if(ss.contains("s=")) {
			ss = ss.replaceAll("s=", " ");
		}
		if(ss.contains("z=")) {
			ss = ss.replaceAll("z=", " ");
		}
		
		System.out.println(ss.length());

	}

}
