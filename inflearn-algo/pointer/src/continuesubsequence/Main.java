package continuesubsequence;

import java.util.Scanner;

public class Main {
  public int solution(int n, int m, int[] arr) {
    // 내가 잔 코드
    // int answer = 0;
    // int len = arr.length;
    // for (int i = 0; i < len; i++) {
    // int sum = 0;
    // int j = i;
    // while (sum < m && j < len) {
    // sum += arr[j++];
    // }
    // if (sum == m) {
    // answer += 1;
    // }
    // }
    
    int answer = 0, sum = 0, lt = 0;
    for (int rt = 0; rt < n; rt++) {
      sum += arr[rt];
      if (sum == m) answer++;
      while (sum >= m) {
        sum -= arr[lt++];
        if (sum == m) answer++;
      }
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
