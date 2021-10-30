package dfsbfs.exam4;

import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] ch;
  public void dfs(int L) {
    if (L == m) {
      for (int i : ch) {
        System.out.print(i + " ");
      }
      System.out.println();
    } else {
      for (int i = 1; i <= n; i++) {
        ch[L] = i;
        dfs(L + 1);
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    ch = new int[m];
    T.dfs(0);
  }
}
