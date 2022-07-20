package programmers.lv2.소수찾기;

import java.util.*;

class Solution {
    boolean[] isVisited;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        isVisited = new boolean[numbers.length()];
        dfs(0, "", numbers);

        return set.size();
    }

    private void dfs(int depth, String str, String numbers) {
        if (str.length() >= 1 && isPrime(Integer.parseInt(str))) {
            set.add(Integer.parseInt(str));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, str + numbers.charAt(i), numbers);
                isVisited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
