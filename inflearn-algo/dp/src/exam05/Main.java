package exam05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public int solution(int n, int[] coins, int m) {
    // 내가 짠 코드
//    int[] arr = new int[m + 1];
//    for (int i = 0; i <= m; i++) {
//      arr[i] = Integer.MAX_VALUE;
//    }
//    for (int coin : coins) {
//      arr[coin] = 1;
//    }
//    for (int i = 1; i <= m; i++) {
//      if (arr[i] != Integer.MAX_VALUE)
//        continue;
//      for (int coin : coins) {
//        if (i - coin < 1)
//          break;
//        arr[i] = Math.min(arr[i], arr[i-coin]+1);
//      }
//    }
    
    int[] arr = new int[m+1];
    Arrays.fill(arr, Integer.MAX_VALUE);
    arr[0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j<= m; j++) {
        arr[j] = Math.min(arr[j], arr[j-coins[i]]+1);
      }
    }

    return arr[m];
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    int m = stdIn.nextInt();
    System.out.println(T.solution(n, arr, m));
  }
}
