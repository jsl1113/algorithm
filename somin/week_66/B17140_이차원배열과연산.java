import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
//꽤 정답까지 갔다고 생각했는데 너무 코드가 더럽고 길고.. 뭐가 틀렸는지 알 수가 없었다..
//왜 정리가 안될까
public class B17140_이차원배열과연산 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int[][] arr = new int[101][101];

        for (int i = 1; i < 4; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        int time = 0;
        int rr = 3;
        int cc = 3;

        while (true) {
            if (arr[r][c] == k) {
                break;
            }
            if (time == 100) {
                time = -1;
                break;
            }

            time++;

            if (rr >= cc) {
                int currentCols = cc;
                cc = 0;

                for (int i = 1; i <= rr; i++) {
                    HashMap<Integer, Integer> countMap = new HashMap<>();
                    List<Node> list = new ArrayList<>();

                    for (int j = 1; j <= currentCols; j++) {
                        if (arr[i][j] != 0) {
                            countMap.put(arr[i][j], countMap.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }

                    if (countMap.isEmpty()) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                        list.add(new Node(entry.getKey(), entry.getValue()));
                    }

                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count > o2.count) {
                            return 1;
                        } else if (o1.count == o2.count) {
                            if (o1.value > o2.value) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    });

                    int index = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (j == 50) {
                            break;
                        }
                        int len = (j + 1) * 2;
                        index = len;
                        Node node = list.get(j);
                        arr[i][len - 1] = node.value;
                        arr[i][len] = node.count;
                    }

                    cc = Math.max(cc, index);
                    for (int j = index + 1; j <= currentCols; j++) {
                        arr[i][j] = 0;
                    }
                }
            } else {
                int currentRows = rr;
                rr = 0;

                for (int i = 1; i <= cc; i++) {
                    HashMap<Integer, Integer> countMap = new HashMap<>();
                    List<Node> list = new ArrayList<>();

                    for (int j = 1; j <= currentRows; j++) {
                        if (arr[j][i] != 0) {
                            countMap.put(arr[j][i], countMap.getOrDefault(arr[j][i], 0) + 1);
                        }
                    }

                    if (countMap.isEmpty()) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                        list.add(new Node(entry.getKey(), entry.getValue()));
                    }

                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count > o2.count) {
                            return 1;
                        } else if (o1.count == o2.count) {
                            if (o1.value > o2.value) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    });

                    int index = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (j == 50) {
                            break;
                        }
                        int len = (j + 1) * 2;
                        index = len;
                        Node node = list.get(j);
                        arr[len - 1][i] = node.value;
                        arr[len][i] = node.count;
                    }

                    rr = Math.max(rr, index);
                    for (int j = index + 1; j <= currentRows; j++) {
                        arr[j][i] = 0;
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Node {
        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}