package exam08;

import java.util.Scanner;

public class Main {
  static int n, f;
  static int[] ch, seq, c;
  int[][] dy = new int[35][35];
  static boolean flag = false;

  public int combi(int n, int r) {
    if (dy[n][r] > 0)
      return dy[n][r];
    if (r == 0 || n == r) {
      return 1;
    }
    return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
  }

  public void dfs(int L, int sum) {
    if (flag)
      return;
    if (L == n) {
      if (sum == f) {
        for (int i : seq) {
          System.out.print(i + " ");
        }
        flag = true;
      }
    } else {
      for (int i = 1; i <= n; i++) {
        if (ch[i] == 0) {
          ch[i] = 1;
          seq[L] = i;
          dfs(L + 1, sum + c[L] * seq[L]);
          ch[i] = 0;
        }
      }
    }

  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    f = stdIn.nextInt();
    ch = new int[n + 1];
    seq = new int[n];
    c = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = T.combi(n - 1, i);
    }
    T.dfs(0, 0);
  }
}
