package sort.ex03;

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {

    for (int i = 1; i < n; i++) {
      int idx = i;
      int min = arr[idx];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] <= min) {
          break;
        } else {
          arr[idx] = arr[j];
          idx = j;
        }
      }
      arr[idx] = min;
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

