package dp.exam01;

import java.util.Scanner;

public class Main {

  public int solution(int n) {
    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i-2] + dp[i-1];
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