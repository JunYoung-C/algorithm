package programmers.greedy.lv2.makebigestnum;

import java.util.Scanner;

public class Solution {
    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        int len = number.length();
        boolean[] notUse = new boolean[len];
        int lt = 0, rt = 0;
        int removedCnt = 0;

        while (rt < len) {
            lt = findMinIndex(rt, number, notUse);
            if (lt >= rt) {
                rt++;
                continue;
            }

//            System.out.print("lt:" + lt + ", " + "rt:" + rt + ", ");
//            for (int i = 0; i < len; i++) {
//                if (!notUse[i]) {
//                    System.out.print(number.charAt(i));
//                }
//            }
//            System.out.println();
            if (number.charAt(lt) >= number.charAt(rt)) {
                rt++;
            } else {
                notUse[lt] = true;
                removedCnt++;
            }

            if (removedCnt == k) {
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (!notUse[i]) {
                answer.append(number.charAt(i));
            }
        }

        String str = answer.toString();
        str = str.substring(0, str.length() - (k - removedCnt));
        return str;
    }

    private int findMinIndex(int rt, String number, boolean[] notUse) {
        for (int i = rt - 1; i >= 0; i--) {
            if (!notUse[i] ) {
                return i;
            }
        }

        return rt;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);
//        String number = "1924";
//        int k = 2;

//        String number = "1231234";
//        int k = 3;

//        String number = "4177252841";
//        int k = 4;

//        String number = "1111111111";
//        int k = 5;

//        String number = "987654321";
//        int k = 3;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sb.append("8");
        }
        String number = sb.toString();
        int k = 500000;
        System.out.println(T.solution(number, k));
    }
}
