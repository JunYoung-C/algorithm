package exam07;

import java.util.Scanner;

public class Main {
    int[][] dy = new int[35][35];
    public int dfs(int n, int r) {
      if (dy[n][r] > 0) return dy[n][r];
      if (n == r || r == 0) return 1;
      else return dy[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }

    public static void main(String[] args) {
      Main T = new Main();
      Scanner stdIn = new Scanner(System.in);
      int n = stdIn.nextInt();
      int r = stdIn.nextInt();
      System.out.println(T.dfs(n, r));
    }
  }

