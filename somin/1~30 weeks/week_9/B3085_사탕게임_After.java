package BOJ.brute_force;
/*
 * 일단 swap 생각을 못했다.
 * 그냥 카운트해주고 board에는 손대지 않고 최댓값을 구하려고 했지만.. 
 * 좋은 생각이 아니었다. ㅜㅜ
 * 
 * 여기의 킥은 swap하고 다시 복구해주는 과정인듯.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3085_사탕게임_After {

	public static char[][] board;
    public static int num;
    public static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
        board = new char[num][num];

        String line = "";
        for(int i = 0; i < num; i++) {
            line = br.readLine();
            board[i] = line.toCharArray();
        }

        //행체크
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num-1; j++) {
            	
                char swap = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = swap;
                
                search();
                
                swap = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = swap;
            }
        }

        //열체크
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num-1; j++) {
                char swap = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = swap;
               
                max = Math.max(search(), max);
               
                swap = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = swap;
            }
        }


        System.out.println(max);

    }

    private static int search() {
        // 가로
        for(int i = 0; i < num; i++) {
            int cnt = 1;
            for(int j = 0; j < num-1; j++) {
                if(board[i][j] == board[i][j+1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로
        for(int i = 0; i < num; i++) {
            int cnt = 1;
            for(int j = 0; j < num-1; j++) {
                if(board[j][i] == board[j+1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }

}
