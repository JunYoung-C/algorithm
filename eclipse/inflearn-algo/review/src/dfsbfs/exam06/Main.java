package dfsbfs.exam06;

import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] arr;
  static int[] ch;
  static int[] nums;
  public void dfs(int L) {
    if (L == m) {
      for (int i : nums) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    } else {
      for (int i = 0; i < n; i++) {
        if (ch[i] == 0) {
          ch[i] = 1;
          nums[L] = arr[i];
          dfs(L+1);
          ch[i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    arr = new int[n];
    ch = new int[n];
    nums = new int[m];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    T.dfs(0);
  }
}
