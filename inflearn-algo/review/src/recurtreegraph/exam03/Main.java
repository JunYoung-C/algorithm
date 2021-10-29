package recurtreegraph.exam03;

import java.util.Scanner;

public class Main {
  public int dfs(int n) {
    if (n == 1) {
      return 1;
    }
    return n * dfs(n-1);
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.print(T.dfs(n));
  }
}
