package dfsbfs.exam07;

import java.util.Scanner;

public class Main {
  static int answer = 0;
  static int[][] ch;
  public int combi(int n, int r) {
    if (ch[n][r] != 0) return ch[n][r];
    if (n == r || r == 0) return ch[n][r] = 1;
    return ch[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int r = stdIn.nextInt();
    ch = new int[n+1][r+1];
    System.out.println(T.combi(n, r));
  }
}
