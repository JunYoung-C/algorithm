package programmers.sorting.lv2.thebigestnum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Solution {
    // 1. 앞자리가 크면 우선순위가 높다.

    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        int len = numbers.length;
        String[] numbersStrArr = new String[len];
        for (int i = 0; i < len; i++) {
            numbersStrArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersStrArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1 + o2);
                int b = Integer.parseInt(o2 + o1);
                return b - a;
            }
        });

        if (numbersStrArr[0].equals("0")) {
            return "0";
        }
        for (String s : numbersStrArr) {
            answer.append(s);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        int[] numbers;

        numbers = new int[] {6, 10, 2};
//        numbers = new int[] {3, 30, 34, 5, 9};
//        numbers = new int[] {1, 10, 100, 1000};
//        numbers = new int[] {0, 10};
        numbers = new int[] {0, 1};
        numbers = new int[] {0, 0};
        System.out.println(T.solution(numbers));
    }
}



