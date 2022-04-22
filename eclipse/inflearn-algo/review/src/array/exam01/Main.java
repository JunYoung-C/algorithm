package array.exam01;

import java.util.Scanner;

public class Main {
  public void solution(int n, int[] arr) {
    System.out.print(arr[0] + " ");
    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[i-1]) {
        System.out.print(arr[i] + " ");
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    T.solution(n, arr);
  }
}
