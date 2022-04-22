package continuousnum;

import java.util.Scanner;

public class Main {
  public int solution(int n, int k, int[] arr) {
    // 시간초과로 틀린 풀이
    // int answer = 0;
    // for (int i = k - 1; i < n; i++) {
    // int sum = 0;
    // for (int j = i - k + 1; j < i + 1; j++) {
    // sum += arr[j];
    // }
    // answer = Integer.max(sum, answer);
    // }
    
    int answer, sum = 0;
    for (int i = 0; i < k; i++) sum += arr[i];
    answer = sum;
    for (int i = k; i < n; i++) {
      sum += (arr[i]- arr[i - k]);
      answer = Math.max(answer, sum);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }

    System.out.println(T.solution(n, m, arr));
  }
}
