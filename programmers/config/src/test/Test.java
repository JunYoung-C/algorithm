package test;

import java.io.IOException;
import java.util.Scanner;

public class Test {
  static int[] ch;
  static int n, m;
  public void dfs(int L, int start) {
    if (L == m) {
      for (int i : ch) {
        System.out.print(i + " ");
      }
      System.out.println();
    } else{
      for (int i = start; i <= n; i++) {
        ch[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Test T = new Test();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    ch = new int[m];
    T.dfs(0, 1);
  }
}
