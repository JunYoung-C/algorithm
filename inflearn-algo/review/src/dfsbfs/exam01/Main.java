package dfsbfs.exam01;

import java.util.Scanner;

public class Main {
  static String answer = "NO";
  static int n;
  static int[] arr;
  static int sum = 0;
  boolean isFind = false;
  public void dfs(int L, int partSum) {
    if (isFind) return;
    if (L == n) {
      if (partSum * 2 == sum) {
        answer = "YES";
        isFind = true;
        return;
      }
    } else {
      dfs(L + 1, partSum + arr[L]);
      dfs(L + 1, partSum);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] =  stdIn.nextInt();
      sum += arr[i];
    }
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
