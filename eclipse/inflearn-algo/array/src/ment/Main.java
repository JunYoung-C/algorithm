package ment;

import java.util.Scanner;

public class Main {
  public int solution(int tests, int students, int[][] arr) {
    int answer = 0;
    for (int me = 1; me <= students; me++) { // 인덱스 x
      // me와 me보다 등수가 낮은 사람들은 값이 0, 높은 사람들은 -1
      int[] myCnt = new int[students];
      myCnt[me-1] = -1;
      for (int test = 0; test < tests; test++) {
        // arr 요소가 me가 아니라면 해당 요소는 짝이 될 수 없음.
        for (int stu = 0; stu < students; stu++) {
          if (arr[test][stu] == me) {
            break;
          }
          myCnt[arr[test][stu]-1] = -1;
        }
      }
      
      // me보다 등수가 낮은 사람들 카운팅
      for (int i = 0; i < students; i++) {
        if (myCnt[i] == 0) {
          answer += 1;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int m = stdIn.nextInt();
    int n = stdIn.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = stdIn.nextInt(); // arr[test][stu]
      }
    }
    System.out.println(T.solution(n, m, arr));
  }
}
