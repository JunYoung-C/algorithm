package programmers.lv2.하노이의탑;

import java.util.*;

class Solution {
    ArrayList<int[]> orders = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(n, 0, 2);
        int len = orders.size();
        answer = new int[len][2];
        for (int i = 0 ; i < len; i++) {
            answer[i] = orders.get(i);
        }
        return answer;
    }

    private void hanoi(int n, int current, int target) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, current, 3 - current - target);
        orders.add(new int[] {current + 1, target + 1});
        hanoi(n - 1, 3 - current - target, target);
    }
}
