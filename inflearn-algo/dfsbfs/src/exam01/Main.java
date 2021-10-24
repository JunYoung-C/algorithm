package exam01;

import java.util.Scanner;

public class Main {
  static int n;
  static int total = 0;
  static String answer = "NO";
  boolean flag = false;
  public void dfs(int L, int sum, int[] arr) {
    if (flag) return;
    if (sum > total / 2) return;
    if (L == n) {
      if ((total - sum) == sum) {
        answer = "YES";
        flag = true;
      }
    } else {
      dfs(L + 1, sum + arr[L], arr);
      dfs(L + 1, sum, arr);
    }
    
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
      total += arr[i];
    }
    T.dfs(0, 0, arr);
    System.out.println(answer);
  }
}
