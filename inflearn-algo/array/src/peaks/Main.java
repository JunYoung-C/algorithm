package peaks;

import java.util.Scanner;

public class Main {
  // 내가 짠 코드
  // public int solution(int n, int[][] arr) {
  // int answer = 0;
  // for (int i = 1; i < n+1; i++) {
  // for(int j = 1; j < n + 1; j++) {
  // if (arr[i-1][j]<arr[i][j] && arr[i][j-1]<arr[i][j] &&arr[i+1][j]<arr[i][j]
  // &&arr[i][j+1]<arr[i][j] ) {
  // answer++;
  // }
  // }
  // }
  // return answer;
  // }
  
  // 방향을 나타내는 배열을 이용
  int[] dx= {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};
  public int solution(int n, int[][] arr) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
            flag = false;
            break;
          }
        }
        if (flag) answer++;
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
//    int[][] arr = new int[n + 2][n + 2];
//    for (int i = 1; i < n + 1; i++) {
//      for (int j = 1; j < n + 1; j++) {
//        arr[i][j] = stdIn.nextInt();
//      }
//    }
    int[][] arr = new int[n][n ];
    for (int i = 0; i < n ; i++) {
      for (int j = 0; j < n ; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
}
