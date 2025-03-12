package com.example.algorithm.study.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// move 음수일 때, 양수일 때에 따라 처리해주지 않아서 헤맸었다.
// 인덱스와 배열로 생각나서 이렇게 풀었지만, 다음에는 덱으로 풀어봐야지
public class B2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i + 1, Integer.parseInt(strArray[i])});
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (list.size() != 1) {
            int move = list.get(idx)[1];
            int size = list.size() - 1;

            sb.append(list.get(idx)[0]).append(" ");
            list.remove(idx);

            // 음수일 때는 왼쪽으로 이동하기 때문에 이미 터진 풍선을 빼주지 않아도 되지만,
            // 양수일 때는 이미 터진 풍선을 빼주어야 한다.
            move -= (move > 0 ? 1 : 0);
            idx = (idx + move) % size;
            idx += (idx < 0 ? size : 0);
        }

        sb.append(list.get(0)[0]);
        System.out.println(sb);
    }
}
