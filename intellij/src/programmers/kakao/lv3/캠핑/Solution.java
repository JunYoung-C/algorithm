package programmers.kakao.lv3.캠핑;

import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;

        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int[] p : data) {
            xList.add(p[0]);
            yList.add(p[1]);
        }

        ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<>(xList));
        ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<>(yList));

        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);

        int[][] dp = new int[5000][5000];

        for (int[] p : data) {
            p[0] = uniqueXList.indexOf(p[0]);
            p[1] = uniqueYList.indexOf(p[1]);
            dp[p[1]][p[0]]++;
        }


        Arrays.sort(data, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p1[0] - p2[0];
        });

        for (int r = 0; r < 5000; r++) {
            for (int c = 0; c < 5000; c++) {
                if (r - 1 >= 0) {
                    dp[r][c] += dp[r - 1][c];
                }

                if (c - 1 >= 0) {
                    dp[r][c] += dp[r][c - 1];
                }

                if (r - 1 >= 0 && c - 1 >= 0) {
                    dp[r][c] -= dp[r - 1][c - 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int x1 = data[i][0];
            int y1 = data[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = data[j][0];
                int y2 = data[j][1];
                if (isValid(Math.min(x1, x2), Math.min(y1, y2),
                        Math.max(x1, x2), Math.max(y1, y2), dp)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isValid(int x1, int y1, int x2, int y2, int[][] dp) {
        if (x1 == x2 || y1 == y2) {
            return false;
        }

        int count = dp[y2 - 1][x2 - 1] - dp[y2 - 1][x1] - dp[y1][x2 - 1] + dp[y1][x1];
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
