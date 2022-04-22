package array.ex05;

import java.util.Scanner;

public class Main {

  public int solution(int n) {
    int answer = 0;
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      if (dp[i] == 0) {
        answer++;
        for (int j = i; j <= n; j += i) {
          dp[j] = -1;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();

    System.out.println(T.solution(n));
  }
}
