package com.example.algorithm.study.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽과 오른쪽 비교해서, 더 작은 쪽 기준으로 빗물을 적립해야 함
// ( 왼쪽 벽이랑 오른쪽 벽이랑 작은 쪽 기준으로 차오르기 때문에 )
// max 값이랑 비교해, max 값 갱신하면서, 빗물을 더해준다
public class B14719_빗물 {
    static int h, w;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        int answer = 0;

        int left = 0, right = w - 1, maxLeft = 0, maxRight = 0;
        while (true) {
            if(left == right) break;

            if (arr[left] < arr[right]) {
                if(arr[left] >= maxLeft) maxLeft = arr[left];
                else answer += maxLeft - arr[left];
                left++;
            } else {
                if(arr[right] >= maxRight) maxRight = arr[right];
                else answer += maxRight - arr[right];
                right--;
            }
        }

        return answer;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
