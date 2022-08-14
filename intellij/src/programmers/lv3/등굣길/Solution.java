package programmers.lv3.등굣길;

class Solution {
    public int solution(int width, int height, int[][] puddles) {
        int[][] dp = new int[height + 1][width + 1];
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }

        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                if (dp[r][c] == -1) {
                    dp[r][c] = 0;
                    continue;
                } else if (r == 1 && c == 1) {
                    dp[r][c] = 1;
                    continue;
                }

                dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % 1000000007;
            }
        }

        // for (int r = 0; r <= height; r++) {
        //     for (int c = 0; c <= width; c++) {
        //         System.out.print(dp[r][c] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[height][width];
    }
}
