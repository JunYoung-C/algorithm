package selection;

import java.util.Scanner;

// 오름차순 정렬

// 입력값
//9
//3 7 1 5 4 2 9 8 6

public class Main {
  public int[] solution(int n, int[] arr) {
    for (int i = 0; i < n - 1; i++) {
      int idx = i;
      
      for (int j = i + 1; j < n; j++) {
        if (arr[idx] > arr[j]) {
          idx = j;
        }
      }
      
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
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


