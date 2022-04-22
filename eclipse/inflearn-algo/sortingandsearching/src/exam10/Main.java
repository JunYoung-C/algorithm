package exam10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public int count(int dist, int[] arr) {
    int pos = arr[0];
    int cnt = 1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] - pos >= dist) {
        pos = arr[i];
        cnt++;
      }
    }
    return cnt;
  }
  public int solution(int n, int c, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int lt = 1;
    int rt = arr[n-1] - arr[0];
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (count(mid, arr) >= c) {
        answer = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int c = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, c, arr));
  }
}
