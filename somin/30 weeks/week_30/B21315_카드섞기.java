import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * ��¥ ���� ����� �־��µ� ......
 * �ʹ� �����ϰ� Ǯ�ٰ� ť�� ��ť�� �������� ��Ȳ�� �Ǿ �����ߴ�.....
 */
public class B21315_ī�弯�� {
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
     * �ӽ� ����Ʈ �ϳ��� ���� ���� ������ �ø� ī��� �� 
     * �ؿ������� 2^k-i+1 ���� ī�带 �ӽ� ����Ʈ�� �־��ְ� 
     * �迭���� 0ǥ�ø� �Ѵ�. �׸����� �迭�� ó������ Ž���ϸ� 
     * 0�� �ƴ� �κ��� �ӽ� ����Ʈ�� �ڿ� �־��ְ� 
     * �ش� ��ġ�� �ӽ� �迭�� ���� ��ġ�� �ִ� ���Ҹ� �־��ָ� �ȴ�.
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
