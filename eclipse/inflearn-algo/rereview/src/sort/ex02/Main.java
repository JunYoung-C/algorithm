package sort.ex02;

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (arr[j] < arr[j - 1]) {
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }

    for (int i : T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}

