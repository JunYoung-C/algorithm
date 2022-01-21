package array.ex09;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[][] map) {
    int answer = 0;

    for (int i = 0; i < n; i++) {
      int rowSum = 0;
      int colSum = 0;
      for (int j = 0; j < n; j++) {
        rowSum += map[i][j];
        colSum += map[j][i];
      }
      
      answer = Math.max(answer, rowSum);
      answer = Math.max(answer, colSum);
    }

    int rtDownSum = 0;
    int ltDownSum = 0;
    for (int i = 0; i < n; i++) {
      rtDownSum += map[i][i];
      ltDownSum += map[n - 1 - i][i];
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, map));
  }
}
