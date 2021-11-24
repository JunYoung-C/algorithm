package bubble;

import java.util.Scanner;

// 오름차순 정렬

// 입력값
// 6
// 13 5 11 7 23 15

public class Main {
  public int[] solution(int n, int[] arr) {
    // 오름차순 방법 1 
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j > i; j--) {
        if (arr[j] < arr[j - 1]) {
          int tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
        }
      }
    }
    
    // 오름차순 방법 2
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
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
