import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 진짜 오래 붙잡고 있었는데 ......
 * 너무 복잡하게 풀다가 큐랑 데큐랑 어지러운 상황이 되어서 포기했다.....
 */
public class B21315_카드섞기 {
	static int n, k, k1, k2;
    static int[] input;
    static int[] deck;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		deck = new int[n];
        input = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            deck[i] = i+1;
        }
        solve();
        System.out.println(k1+" "+k2);
		
	}
	
	static void solve() {
        for(int i = 1; Math.pow(2,i) < n; i++) {
            for(int j = 1; Math.pow(2,j) < n; j++) {
                int[] arr = deck.clone();
                shuffle(i, arr);
                shuffle(j, arr);
                boolean flag = true;
                for(int k = 0; k < n; k++) {
                    if(arr[k] != input[k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    k1 = i;
                    k2 = j;
                    return;
                }
            }
        }
    }

    static void shuffle(int k, int[] arr) {
        int range = n;
        int cnt;
        for(int i = 1; i <= k+1; i++) {
            cnt =(int)Math.pow(2, k-i+1);
            swap(range,cnt, arr);
            range = cnt;
        }
    }

    /*
     * 임시 리스트 하나를 만들어서 직전 맨위로 올린 카드들 중 
     * 밑에서부터 2^k-i+1 개의 카드를 임시 리스트에 넣어주고 
     * 배열에는 0표시를 한다. 그리고나서 배열의 처음부터 탐색하며 
     * 0이 아닌 부분은 임시 리스트의 뒤에 넣어주고 
     * 해당 위치에 임시 배열의 같은 위치에 있는 원소를 넣어주면 된다.
     */
    static void swap(int range, int cnt, int[] arr) {
        List<Integer> tmp = new ArrayList<>();
        
        for(int i = range-cnt; i < range; i++) {
            tmp.add(arr[i]);
            arr[i] = 0;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                tmp.add(arr[i]);
            }
            arr[i] = tmp.get(i);
        }
    }


}
