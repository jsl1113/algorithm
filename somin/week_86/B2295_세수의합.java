import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B2295_세수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
        int[] u = new int[n];
        
        for (int i=0;i<n;i++) {
            u[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(u);  
        Set<Integer> sum = new HashSet<>();
        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++) {
                sum.add(u[i]+u[j]);
            }
        }

        for (int k=n-1;k>=0;k--) {
            for (int i=0;i<n;i++) {
                int target = u[k]-u[i];
                if (sum.contains(target)) {
                    System.out.println(u[k]);
                    return;
                }
            }
        }
    }
}