package array.exam07;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[] arr) {
    int answer = 0;
    int p = 1;
    answer += arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] == 1) {
        if (arr[i-1] == 1) {
          p++;
        }
        answer += p;
      } else {
        p = 1;
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
