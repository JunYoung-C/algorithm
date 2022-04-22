package exam04;

import java.util.Scanner;

public class Main {
  public int[] solution(int caches, int n, int[] arr) {
    int[] answer = new int[caches];
    for (int work : arr) {
      int index = caches - 1;
      // arr에 값이 존재하는지 확인
      for (int i = 0; i < caches; i++ ) {
        if (work == answer[i]) {
          index = i;
        }
      }
      
      for (int i = index; i >= 1; i--) {
        answer[i] = answer[i-1];
      }
      answer[0] = work;
    }


    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int s = stdIn.nextInt();
    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    for (int i : T.solution(s, n, arr)) {
      System.out.print(i + " ");
    }
  }
}
