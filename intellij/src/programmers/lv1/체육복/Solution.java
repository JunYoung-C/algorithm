package programmers.lv1.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 2];
        Arrays.fill(clothes, 1);

        for (int num : lost) {
            clothes[num]--;
        }

        for (int num : reserve) {
            clothes[num]++;
        }

        for (int num = 1; num <= n; num++) {
            if (clothes[num] != 2) {
                continue;
            }

            if (clothes[num - 1] == 0) {
                clothes[num - 1]++;
                clothes[num]--;
            } else if (clothes[num + 1] == 0) {
                clothes[num + 1]++;
                clothes[num]--;
            }
        }

        for (int num = 1; num <= n; num++) {
            if (clothes[num] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}
