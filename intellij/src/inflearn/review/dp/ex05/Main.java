package inflearn.review.dp.ex05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int n, int[] coins, int m) {
        int answer = 0;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int coin : coins) {
            dp[coin] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int coin : coins) {
                if (i - coin >= 1 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        answer = dp[m];
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = stdIn.nextInt();
        }
        int m = stdIn.nextInt();
        System.out.println(T.solution(n, coins, m));
    }
}