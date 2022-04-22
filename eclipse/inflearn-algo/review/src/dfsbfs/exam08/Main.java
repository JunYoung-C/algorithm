package dfsbfs.exam08;

import java.util.Scanner;

public class Main {
  static int n, f;
  static int[] ch, arr;
  static int[] combi;
  static int[][] combiCh;
  boolean isFind = false;
  public int combination(int n, int r) {
    if (combiCh[n][r] > 0)
      return combiCh[n][r];
    if (n == r || r == 0)
      return 1;
    return combiCh[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
  }

  public void dfs(int L, int sum) {
    if (isFind) return;
    if (L == n) {
      // arr에 있는 수를 더한 후 f와 비교
      if (sum == f) {
        for (int i : arr) {
          System.out.print(i + " ");
        }
        System.out.println();
        isFind = true;
      }
    } else {
      for (int i = 1; i <= n; i++) {
        if (ch[i] == 0) {
          ch[i] = 1;
          arr[L] = i;
          dfs(L + 1, sum + i * combi[L]);
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
    arr = new int[n];
    combi = new int[n];
    combiCh = new int[n+1][n+1];
    for (int i = 0; i < n; i++) {
      combi[i] = T.combination(n - 1, i);
    }

    T.dfs(0, 0);
  }
}
