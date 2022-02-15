package programmers.dp.lv3.presentationbyn;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int solution(int N, int number) {
        ArrayList<Integer> createdNum = new ArrayList<>();
        int answer = 0;
        // 행 : N이 사용되는 개수, 열 : 해당되는 숫자들
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new ArrayList<>());
        }
        createdNum.add(N);

        int handledN = N;
        for (int i = 1; i <= 8; i++) {
            if (number == handledN) {
                return i;
            }
            dp.get(i).add(handledN);
            handledN  = handledN * 10 + N;
        }
        for (int cnt = 2; cnt <= 8; cnt++) { // i == 카운트
            for (int j = 1; j < cnt; j++) { // i와 i - j 연산
                for (int lt : dp.get(j)) {
                    for (int rt : dp.get(cnt - j)) {
                        for (int num : operate(lt, rt)) {
                            if (num == number) {
                                return cnt;
                            }
                            if (num >= 0 && !createdNum.contains(num)) {
                                createdNum.add(num);
                                dp.get(cnt).add(num);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    int[] operate(int a, int b) {
        // 5와 5간의 연산의 경우 55, 10, 0, 25, 1
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(a + b);
        arr.add(a - b);
        arr.add(a * b);
        if (b != 0) {
            arr.add(a / b);
        }

        int len = arr.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int n;
        int number;

//        n = 5;
//        number = 12;

//        n = 2;
//        number = 11;

        n = 5;
        number = 31168;
//        n = 1;
//        number = 561;

        System.out.println(T.solution(n, number));
    }
}
