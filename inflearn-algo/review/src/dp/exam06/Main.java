package dp.exam06;

import java.util.Scanner;

public class Main {

  public int solution(int n, int limited, int[] points, int[] times) {
    int[] dp = new int[limited+1];
    for (int i = 0; i < n; i++) {
      int p = points[i];
      int t = times[i];
      for (int time = limited; time >= t; time--) {
        dp[time] = Math.max(dp[time], dp[time-t] + p);
      }
    }
    return dp[limited];
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[] points = new int[n];
    int[] times = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = stdIn.nextInt();
      times[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, m, points, times));
  }
}
