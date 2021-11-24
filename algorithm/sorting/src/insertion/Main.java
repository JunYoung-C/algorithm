package insertion;

import java.util.Scanner;

// 오름차순 정렬

// 입력
// 6
// 11 7 5 6 10 9

// 출력
// 5 6 7 9 10 11
public class Main {
  public int[] solution(int n, int[] arr) {
    for (int i = 1; i < n; i++) {
      int tmp = arr[i], j;
      for (j = i - 1; j >= 0; j--) {
        if (tmp < arr[j]) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = tmp;
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
