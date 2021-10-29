package recurtreegraph.exam04;

import java.util.Scanner;

public class Main {
  static int[] fibo;
  public int dfs(int n) {
    if (fibo[n] != 0) {
      return fibo[n];
    }
    if (n == 1) return 1;
    if (n == 2) return 1;
    return fibo[n] = dfs(n - 2) + dfs(n-1);
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    fibo = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      System.out.print(T.dfs(i) + " ");
    }
  }
}
