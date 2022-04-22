package twopoint.ex01;

import java.util.Scanner;

public class Main {

  public int[] solution(int n1, int[] arr1, int n2, int[] arr2) {
    int[] answer = new int[n1 + n2];
    int idx = 0;
    int i1 = 0;
    int i2 = 0;

    while (true) {
      if (arr1[i1] < arr2[i2]) {
        answer[idx++] = arr1[i1++];
      } else {
        answer[idx++] = arr2[i2++];
      }

      if (i1 >= n1 || i2 >= n2) {
        break;
      }
    }
    
    while (i1 < n1) {
      answer[idx++] = arr1[i1++];
    }
    while (i2 < n2) {
      answer[idx++] = arr2[i2++];
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0; i < n; i++) {
      arr1[i] = stdIn.nextInt();
    }

    int m = stdIn.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0; i < m; i++) {
      arr2[i] = stdIn.nextInt();
    }
    for (int i : T.solution(n, arr1, m, arr2)) {
      System.out.print(i + " ");
    }
  }
}
