package programmers.kakao.보행자맞추기;

class Solution {
    int MOD = 20170805;
    public int solution(int height, int width, int[][] cityMap) {
        int answer = 0;
        int[][] dp = new int[height][width];
        dp[0][0] = 1;
        for (int r = 1; r < height; r++) {
            if (cityMap[r][0] == 1) {
                break;
            }
            dp[r][0] += dp[r - 1][0];
        }

        for (int c = 1; c < width; c++) {
            if (cityMap[0][c] == 1) {
                break;
            }
            dp[0][c] += dp[0][c - 1];
        }

        for (int r = 1; r < height; r++) {
            for (int c = 1; c < width; c++) {
                if (cityMap[r][c] != 0) {
                    continue;
                }

                int sum = 0;
                int prevRow = r - 1;
                while (prevRow >= 0 && cityMap[prevRow][c] == 2) {
                    prevRow--;
                }

                if (prevRow >= 0) {
                    sum += dp[prevRow][c];
                }

                int prevCol = c - 1;
                while (prevCol >= 0 && cityMap[r][prevCol] == 2) {
                    prevCol--;
                }

                if (prevCol >= 0) {
                    sum += dp[r][prevCol];
                }

                // System.out.println(r + " " + prevRow + " " + c + " " + prevCol + " " + sum);
                dp[r][c] = sum % MOD;
            }
        }

        // for (int r = 0; r < height; r++) {
        //     for (int c = 0; c < width; c++) {
        //         System.out.print(dp[r][c] + " " );
        //     }
        //     System.out.println();
        // }

        return dp[height - 1][width - 1];
    }
}

