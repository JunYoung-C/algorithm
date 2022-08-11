package programmers.lv3.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int outTime = -30001;
        for (int[] route : routes) {
            if (outTime >= route[0]) {
                outTime = Math.min(outTime, route[1]);
            } else {
                answer++;
                outTime = route[1];
            }
        }

        return answer;
    }
}
