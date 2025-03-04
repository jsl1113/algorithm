import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int n,k;
    static boolean[] visit;
    static int[] arr;
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            arr = new int[n];
            visit = new boolean[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int[] now = new int[k];
            dfs(0,now);
            System.out.println(map.size());

    }

    static void dfs(int cnt, int[] now){

        if(cnt == k ){
            String s = "";
            for(int aa : now){
                s +=aa;
            }
            map.put(s,1);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                now[cnt] = arr[i];
                dfs(cnt+1,now );
                visit[i] = false;
            }
        }

    }
}
