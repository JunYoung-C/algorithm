package exam08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public int solution(int n, int m, int[] arr) {
    int answer = -1;
    Arrays.sort(arr);
    int lt = 0;
    int rt = n-1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (arr[mid] == m) {
        return mid + 1;
      } else if (arr[mid] > m) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
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
