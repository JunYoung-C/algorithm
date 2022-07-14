package programmers.lv1.소수찾기;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int num = 2; num <= n; num++) {
            if (!isPrime[num]) {
                continue;
            }

            for (int next = num * 2; next <= n; next += num) {
                isPrime[next] = false;
            }
        }

        for (int num = 2; num <= n; num++) {
            if (isPrime[num]) {
                answer++;
            }
        }


        return answer;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
