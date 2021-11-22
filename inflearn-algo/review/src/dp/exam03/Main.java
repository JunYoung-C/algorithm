package dp.exam03;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[] arr) {
    int answer = 1;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = i-1; j >= 0; j--) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }

//    for (int i : dp) {
//      System.out.print(i + " " );
//    }
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
