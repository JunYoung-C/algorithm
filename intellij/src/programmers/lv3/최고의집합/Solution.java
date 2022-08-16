package programmers.lv3.최고의집합;

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        for (int i = n; i >= 1; i--) {
            int num = s / i;
            if (num == 0) {
                return new int[]{-1};
            }
            s -= num;
            answer[n - i] = num;
        }
        // Arrays.sort(answer);
        return answer;
    }
}
