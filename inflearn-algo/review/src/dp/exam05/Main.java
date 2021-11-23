package dp.exam05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public int solution(int n, int[] coins, int m) {
    int[] dp = new int[m + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int coin : coins) {
      for (int i = coin; i <= m; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[m];
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
