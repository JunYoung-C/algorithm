package recurtreegraph.exam02;

import java.util.Scanner;

public class Main {
  public void dfs(int n) {
    if (n == 0) return;
    dfs(n/2);
    System.out.print(n%2);

  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    T.dfs(n);
  }
}
