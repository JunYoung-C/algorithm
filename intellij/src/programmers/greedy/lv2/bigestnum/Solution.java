package programmers.greedy.lv2.bigestnum;

import java.util.Scanner;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int changedCursorMinCnt = len -1;

        for (int i = 0; i < len; i++) {
            answer += countChangedAlphabet(name.charAt(i));
        }
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            for (; j < len; j++) {
                if (name.charAt(j) != 'A') {
                    break;
                }
            }

            changedCursorMinCnt = Math.min(changedCursorMinCnt, len - j + i + Math.min(i, len - j));
        }

        answer += changedCursorMinCnt;
//        System.out.println("changedCursorMinCnt = " + changedCursorMinCnt);
//        System.out.println("changedAlphabetCnt = " + changedAlphabetCnt);
        return answer;
    }

    int countChangedAlphabet(char c) {
        return Math.min(c - 'A', 'Z' + 1 - c);
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String name = "JEROEN";
//        String name = "JAN";
//        String name = "ABAAAB";
//        String name = "AAA";
//        String name = "ABA";
//        String name = "BAA";
//        String name = "ZAA";
//        String name = "AAAA";
//        String name = "ABAA";
//        String name = "AAAB";
        String name = "ABAAABA";
        System.out.println(T.solution(name));
    }
}
