package backjoon.dp.ex9252;

import java.io.*;

public class Main {
    StringBuilder sb = new StringBuilder();

    public void solution(String str1, String str2) {
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int width = charArr1.length;
        int height = charArr2.length;

        int[][] dp = new int[height + 1][width + 1];
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width;col++) {
                if (charArr1[col - 1] == charArr2[row - 1]) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        System.out.println(dp[height][width]);
        if (dp[height][width] == 0) {
            return;
        }

        dfs(height, width, dp, charArr1, charArr2);
//        for (int row = 1; row <= height; row++) {
//            for (int col = 1; col <= width;col++) {
//                System.out.print(dp[row][col] + " ");
//            }
//
//            System.out.println();
//        }



    }

    private void dfs(int y, int x, int[][] dp, char[] charArr1, char[] charArr2) {
        if (charArr1[x - 1] == charArr2[y - 1]) {
            // 왼쪽 위로 이동
            sb.append(charArr1[x - 1]);
            if (dp[y][x] == 1) {
                System.out.println(sb.reverse());
                return;
            }
            dfs(y - 1, x - 1, dp, charArr1, charArr2);
        } else {
            // 왼쪽과 위쪽 중 큰 쪽으로 이동
            if (dp[y - 1][x] > dp[y][x - 1]) {
                dfs(y - 1, x, dp, charArr1, charArr2);
            } else {
                dfs(y, x - 1, dp, charArr1, charArr2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        br.close();
        T.solution(str1, str2);
    }
}
