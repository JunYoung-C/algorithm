package programmers.kakao.lv2.n진수게임;

import java.util.Scanner;

class Solution {
    public String solution(int k, int sayCount, int n, int order) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (sb.length() < sayCount * n) {
            sb.append(Integer.toString(number++, k));
        }

        String str = sb.toString();
        sb.setLength(0);
        int count = 0;
        for (int i = order - 1; i < str.length(); i += n) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            count++;
            if (count == sayCount) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        System.out.println(T.solution(2, 4, 2, 1));
    }
}
