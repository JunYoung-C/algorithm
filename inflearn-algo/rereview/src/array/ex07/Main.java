package array.ex07;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[] arr) {
    int answer = 0;
    int point = 1;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        answer += point;
        point++;
      } else {
        point = 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }
}
