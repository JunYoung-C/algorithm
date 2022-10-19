package backjoon.dp.ex9251;

import java.util.Scanner;

public class Main {
    public int solution(String str1, String str2) {
        int answer = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i1 = 0; i1 < str1.length(); i1++) {
            for (int i2 = 0; i2 < str2.length(); i2++) {
                dp[i1 + 1][i2 + 1] = Math.max(dp[i1][i2 + 1], dp[i1 + 1][i2]);

                if (str1.charAt(i1) == str2.charAt(i2)) {
                    dp[i1 + 1][i2 + 1] = Math.max(dp[i1 + 1][i2 + 1], dp[i1][i2] + 1);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        String str1 = stdIn.next();
        String str2 = stdIn.next();

        System.out.println(T.solution(str1, str2));
    }
}
