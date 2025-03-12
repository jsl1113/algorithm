package com.example.algorithm.study;

import java.io.*;
import java.util.*;

// 카드를 스와핑하고 섞는 과정이 잘 이해가지 않았다
// Math.pow(2, k - i + 1) 개의 카드를 임시 배열에 옮기기
// 처음엔 deque를 쓰는가 했는데 잘 모르겠다 ...
/*
 * 1. 리스트에 밑에서부터 cnt 개 만큼 카드를 넣어줌 ( 카드를 위로 올리는 과정 )
 * 2. 나머지 수를 리스트에 추가하고 카드에 저장
 */
public class B21315_카드섞기 {
    static int n;
    static int[] arr, card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        card = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[i] = i + 1;
        }

        // 1 ≤ K, 2^K < N
        for (int k1 = 1; Math.pow(2, k1) < n; k1++) { // n=5,  k1: 1, 2
            for (int k2 = 1; Math.pow(2, k2) < n; k2++) { //  n=5,  k2: 1, 2
                int[] cards = card.clone();
                shuffle(k1, cards);
                shuffle(k2, cards);

                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (cards[i] != arr[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }

    }

    static void shuffle(int k, int[] cards) {
        int size = n;
        int cnt;

        for (int i = 1; i <= k + 1; i++) {
            cnt = (int) Math.pow(2, k - i + 1);
            swap(size, cnt, cards);
            size = cnt;
        }
    }

    static void swap(int size, int cnt, int[] cards) {
        List<Integer> list = new ArrayList<>();

        for (int i = size - cnt; i < size; i++) {
            list.add(cards[i]);
            cards[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (cards[i] != 0) {
                list.add(cards[i]);
            }
            cards[i] = list.get(i);
        }
    }
}
