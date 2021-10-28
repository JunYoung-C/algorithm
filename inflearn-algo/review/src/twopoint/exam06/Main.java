package twopoint.exam06;

import java.util.Scanner;

public class Main {
  public int solution(int n, int k, int[] arr) {
    int answer = Integer.MIN_VALUE;
    int lt = 0;
    int cnt = 0;
    int rt;
    for (rt = 1; rt <= n; rt++) {
      if (arr[rt] == 0) {
        cnt++;
      }
      
      if (cnt > k) {
        answer = Math.max(answer, rt - lt - 1);
        while (cnt > k) {
          lt++;
          if (arr[lt] == 0) {
            cnt--;
          }
        }
      }
      
    }
    answer = Math.max(answer, rt - lt - 1);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n+1];
    for (int i = 1; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
  }
}
