package programmers.lv2.n개의최소공배수;

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int gcd = gcd(answer, arr[i]);
            answer *= arr[i] / gcd;
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}