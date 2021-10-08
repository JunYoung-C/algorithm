package maxsum;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[][] arr) {
    int answer = 0;
    // 내가 짠 코드
    // ArrayList<Integer> arrList = new ArrayList<>();
    // // 가로 합
    // for (int row = 0; row < n; row++) {
    // int sum = 0;
    // for (int col = 0; col < n; col++) {
    // sum += arr[row][col];
    // }
    // arrList.add(sum);
    // }
    //
    // // 세로 합
    // for (int col = 0; col < n; col++) {
    // int sum = 0;
    // for (int row = 0; row < n; row++) {
    // sum += arr[row][col];
    // }
    // arrList.add(sum);
    // }
    //
    // // 대각선 합
    // int sum = 0;
    // for (int row = 0, col = 0; row < n && col < n; row++, col++) {
    // sum += arr[row][col];
    // }
    // arrList.add(sum);
    // sum = 0;
    // for (int row = n-1,col = 0; row>=0 && col < n; row--, col++) {
    // sum += arr[row][col];
    // }
    // arrList.add(sum);
    //
    // for(int i: arrList) {
    // if (i > answer) {
    // answer = i;
    // }
    // }
    int sum1, sum2;
    for (int i = 0; i < n; i++) {
      sum1 = sum2 = 0;
      for (int j = 0; j < n; j++) {
        sum1 += arr[i][j];
        sum2 += arr[j][i];
      }
      answer = Math.max(answer, sum1);
      answer = Math.max(answer, sum2);
    }
    sum1 = sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += arr[i][i];
      sum2 += arr[i][n-i-1];
    }
    answer = Math.max(answer, sum1);
    answer = Math.max(answer, sum2);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
}
