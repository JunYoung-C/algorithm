package recurtreegraph.exam06;

import java.util.Scanner;

public class Main {
  static int[] ch;
  static int n;
  static int answer = 0;

  public void dfs(int L) {
    if (L > n) { 
      String str = "";
      for (int i = 1; i <= n; i++) {
        if (ch[i] > 0) {
          str += i;
        }
      }
      
      for (char c : str.toCharArray()) {
        System.out.print(c + " ");
      }
      System.out.println();
    } else {
      ch[L] = 1;
      dfs(L+1);
      ch[L] = 0;
      dfs(L+1);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    ch = new int[n + 1];
    T.dfs(1);
  }
}
