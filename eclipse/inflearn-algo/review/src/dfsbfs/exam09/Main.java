package dfsbfs.exam09;

import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] ch;

  public void dfs(int L, int s) {
    if (L == m) {
      for (int i : ch) {
        System.out.print(i + " ");
      }
      System.out.println();
    } else {
      for (int i = s; i <= n; i++) {
        ch[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    ch = new int[m];
    T.dfs(0, 1);
  }
}
