package backjoon.dp.ex2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] coins) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100_000);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return dp[k] >= 100_000 ? -1 : dp[k];
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int k = stdIn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = stdIn.nextInt();
        }
        System.out.println(T.solution(n, k, coins));
    }
}
