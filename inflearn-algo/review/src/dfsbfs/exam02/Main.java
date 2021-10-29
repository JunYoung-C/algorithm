package dfsbfs.exam02;

import java.util.Scanner;

public class Main {
  static int answer = Integer.MIN_VALUE;
  static int limit, n;
  static int[] weights;
  public void dfs(int L, int sum) {
    if (sum > limit) return;
    if (L == n) {
      answer = Integer.max(answer, sum);
      return;
    } else {
      dfs(L + 1, sum + weights[L]);
      dfs(L + 1, sum);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    limit =stdIn.nextInt();
    n = stdIn.nextInt();
    weights = new int[n];
    for (int i = 0; i < n; i++) {
      weights[i] = stdIn.nextInt();
    }
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
