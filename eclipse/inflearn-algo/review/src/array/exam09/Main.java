package array.exam09;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[][] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sum1 = 0;
      int sum2 = 0;
      for (int j = 0; j < n; j++) {
        sum1 += arr[i][j];
        sum2 += arr[j][i];
      }
      max = Integer.max(max, sum1);
      max = Integer.max(max, sum2);
    }
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += arr[i][i];
      sum2 += arr[n - i - 1][i];
    }
    max = Integer.max(max, sum1);
    max = Integer.max(max, sum2);
    return max;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }

    System.out.println(T.solution(n, arr));
  }
}
