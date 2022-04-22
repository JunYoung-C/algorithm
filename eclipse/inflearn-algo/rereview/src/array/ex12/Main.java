package array.ex12;

import java.util.Scanner;

public class Main {

  // n : 반 학생 수, m : 테스트 횟수
  public int solution(int n, int m, int[][] testsArr) {
    int answer = 0;
    boolean[][] canPair;
    canPair = new boolean[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        canPair[i][j] = true;
      }
    }
    
    for (int[] students : testsArr) {
      for (int myRank = 1; myRank <= n; myRank++) {
        int me = students[myRank];
        for (int yourRank = myRank + 1; yourRank <= n; yourRank++) {
          int you = students[yourRank];
          canPair[you][me] = false;
        }

      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (canPair[i][j]) {
          answer++;
        }
        
      }

    }
    return answer - n;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[][] testsArr = new int[m + 1][n + 1];
    for (int row = 0; row < m; row++) {
      for (int col = 1; col <= n; col++) {
        testsArr[row][col] = stdIn.nextInt();
      }
    }

    System.out.println(T.solution(n, m, testsArr));
  }
}
