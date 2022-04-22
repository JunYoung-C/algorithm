package array.exam12;

import java.util.Scanner;

public class Main {
  public int solution(int ranks, int tests, int[][] arr) {
    int answer = -ranks;
    int[][] ch = new int[ranks][ranks];
    for (int test = 0;test < tests; test++) {
      for (int rank = 0;rank < ranks; rank++) {
        int me = arr[test][rank]-1;
        for (int i = 0; i < rank; i++) {
          int stu = arr[test][i]-1;
          ch[me][stu] = -1;
        }
      }
    }
    
    for (int i = 0; i < ranks; i++) {
      for (int j = 0; j < ranks; j++) {
        if (ch[i][j] == 0) answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }

    System.out.println(T.solution(n, m, arr));
  }
}
