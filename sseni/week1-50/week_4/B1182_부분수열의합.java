package com.example.algorithm.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 비트마스킹으로 부분 수열을 구했는데, 막상 성능은 재귀가 더 좋은 거 같다.
// stream 으로 코드 단축시키려다가 그냥 반복문으로 더한 거랑 좀 성능 차이나네
public class B1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int mask = 1; mask < (int) Math.pow(2, n); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0){
                    list.add(arr[i]);
                }
            }

            int tmp = 0;
            for(int l : list) tmp += l;
            if(tmp == sum) cnt ++;

//            if(list.stream().mapToInt(Integer::intValue).sum() == sum) cnt++;
        }

        System.out.println(cnt);
    }
}
