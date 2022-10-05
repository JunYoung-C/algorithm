package backjoon.dp.ex2293;

import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] coins) {
        int[] dp = new int[k + 1];

        for (int coin : coins) {
            if (coin > k) {
                continue;
            }
            dp[coin]++;
            for (int i = coin + 1; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[k];
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
