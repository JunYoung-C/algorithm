package rank;

import java.util.Scanner;

public class Main {
  // 내가 짠 코드
  // public int[] solution(int n, int[] nums) {
  // int rank = 0;
  // int cnt = 0;
  // int prev = Integer.MAX_VALUE;
  // for (int j = 0; j < n; j++) {
  // int max = Integer.MIN_VALUE;
  // int index = 0;
  //
  // for (int i = 0; i < n; i++) {
  // if (max < nums[i]) {
  // max = nums[i];
  // index = i;
  // }
  // }
  //
  // cnt--;
  // if (prev > max) {
  // rank = cnt;
  // prev = max;
  // }
  // nums[index] = rank;
  // }
  // return nums;
  // }

  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = 0; j < n; j++) {
        if (arr[j] > arr[i]) cnt++;
      }
      answer[i] = cnt;
    }
    return answer;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = stdIn.nextInt();
    }
    for (int i : T.solution(n, nums)) {
      System.out.print(-i + " ");
    }
  }
}
