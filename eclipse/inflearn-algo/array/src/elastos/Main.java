package elastos;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int[] arr = new int[n + 1];
    arr[0] = -1;
    arr[1] = -1;
    for (int i = 2; i < n + 1; i++) {
      if (arr[i] == 0) {
        arr[i] = 1;
        for (int j = 2 * i; j < n + 1; j += i) {
          arr[j] = -1;
        }
      }
    }

    for (int i : arr) {
      if (i == 1) {
        answer += 1;
      }
    }
    // 1을 저장하고 나중에 카운팅 대신, 바로 카운팅해도 가능하다.
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}
