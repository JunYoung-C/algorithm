package programmers.lv2.땅따먹기;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int width = 4;
        int height = land.length;
        int[][] dp = new int[height][width];
        for (int col = 0; col < width; col++) {
            dp[0][col] = land[0][col];
        }

        for (int row = 1; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int prevCol = 0; prevCol < width; prevCol++) {
                    if (col == prevCol) {
                        continue;
                    }

                    dp[row][col] = Math.max(dp[row - 1][prevCol] + land[row][col], dp[row][col]);
                }
            }
        }

        for (int col = 0; col < width; col++) {
            answer = Math.max(dp[height - 1][col], answer);
        }
//         for (int row = 0; row < height; row++) {
//             for (int col = 0; col < width; col++) {
//                 System.out.print(dp[row][col] + " ");
//             }

//             System.out.println();
//         }

        return answer;
    }
}
