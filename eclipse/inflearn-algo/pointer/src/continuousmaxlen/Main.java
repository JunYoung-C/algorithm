package continuousmaxlen;

import java.util.Scanner;

public class Main {
  public int solution(int n, int k, int[] arr) {
    // 못품
    int answer = 0, cnt = 0, lt = 0;
    for (int rt = 0; rt < n; rt++) {
      if (arr[rt] == 0) {
        cnt++;
      }
      while (cnt > k) {
        if (arr[lt] == 0) {
          cnt--;
        }
        lt++;
      }

      answer = Math.max(answer, rt - lt + 1);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
  }
}
