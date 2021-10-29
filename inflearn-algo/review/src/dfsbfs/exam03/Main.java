package dfsbfs.exam03;

import java.util.Scanner;

public class Main {
  static int answer = Integer.MIN_VALUE;
  static int n, limitTime;
  static int[] points, times;
  public void dfs(int L, int timeSum, int pointSum) {
    if (timeSum > limitTime) {
      return;
    }
    if (L == n) {
      answer = Math.max(answer, pointSum);
    } else {
      dfs(L + 1, timeSum + times[L], pointSum + points[L]);
      dfs(L + 1, timeSum, pointSum);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    limitTime = stdIn.nextInt();
    points = new int[n];
    times = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = stdIn.nextInt();
      times[i] = stdIn.nextInt();
    }
    T.dfs(0, 0, 0);
    System.out.println(answer);
  }
}
