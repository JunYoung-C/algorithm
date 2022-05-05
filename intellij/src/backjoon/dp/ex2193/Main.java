package backjoon.dp.ex2193;

import java.util.Scanner;

public class Main {
    public long solution(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        System.out.println(T.solution(n));
    }
}
