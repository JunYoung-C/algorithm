package sort.ex01;

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {
    int minIdx;
    for (int i = 0; i < n; i++) {
      minIdx = i;
      for (int j = i; j < n; j++) {
        if (arr[minIdx] > arr[j]) {
          minIdx = j;
        }
      }
      int tmp = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = tmp;
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
