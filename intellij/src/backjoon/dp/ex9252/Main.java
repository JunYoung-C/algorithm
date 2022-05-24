package backjoon.dp.ex9252;

import java.io.*;

public class Main {
    StringBuilder sb = new StringBuilder();
    int[][] dp;
    public void solution(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[len1][len2]);
        getText(len1, len2, str1, str2);
        System.out.println(sb.reverse());
    }

    private void getText(int r, int c, String str1, String str2) {
        if (r == 0 || c == 0) {
            return;
        }

        if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
            sb.append(str1.charAt(r - 1));
            getText(r - 1, c - 1, str1, str2);
        } else {
            if (dp[r - 1][c] > dp[r][c - 1]) {
                getText(r - 1, c, str1, str2);
            } else {
                getText(r, c - 1, str1, str2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        T.solution(str1, str2);
    }
}
