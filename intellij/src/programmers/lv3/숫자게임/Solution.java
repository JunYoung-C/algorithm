package programmers.lv3.숫자게임;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx1 = 0;
        int idx2 = 0;
        int len = A.length;
        while (idx1 < len && idx2 < len) {
            if (B[idx2] > A[idx1]) {
                answer++;
                idx2++;
                idx1++;
            } else {
                idx2++;
            }
        }
        return answer;
    }
}
