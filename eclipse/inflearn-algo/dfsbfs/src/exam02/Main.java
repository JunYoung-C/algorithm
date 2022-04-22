package exam02;

import java.util.Scanner;

public class Main {
  static int c;
  static int n;
  static int[] arr;
  static int answer = Integer.MIN_VALUE;

  public void dfs(int L, int sum) {
    if (sum > c)
      return;
    if (L == n) {
      answer = Integer.max(answer, sum);
    } else {
      dfs(L + 1, sum + arr[L]);
      dfs(L + 1, sum);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    c = stdIn.nextInt();
    n = stdIn.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
