package programmers.kakao.lv3.캠핑;

import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            int upperY = Integer.MAX_VALUE;
            int lowerY = 0;
            // data -> x, y

            for (int j = i + 1; j < n; j++) {
                if (data[j][1] >= data[i][1]) {
                    if (data[j][1] > upperY) {
                        continue;
                    }

                    upperY = data[j][1];
                    if (isPossibleArea(data[i], data[j])) {
                        // System.out.println(data[i][0] + "," + data[i][1] + " " + data[j][0] + "," + data[j][1]);
                        answer++;
                    }
                } else {
                    if (data[j][1] < lowerY) {
                        continue;
                    }

                    lowerY = data[j][1];
                    if (isPossibleArea(data[i], data[j])) {
                        answer++;
                        // System.out.println(data[i][0] + "," + data[i][1] + " " + data[j][0] + "," + data[j][1]);
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPossibleArea(int[] p1, int[] p2) {
        if (p1[0] - p2[0] == 0 || p1[1] - p2[1] == 0) {
            return false;
        }
        return true;
    }
}
