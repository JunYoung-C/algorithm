package array.exam10;

import java.util.Scanner;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int solution(int n, int[][] map) {
    int answer = 0;
    for (int y = 1; y < n + 1; y++) {
      for (int x = 1; x < n + 1; x++) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          if (map[y][x] <= map[ny][nx]) {
            flag = false;
            break;
          }
        }
        if (flag)
          answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[][] map = new int[n + 2][n + 2];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, map));
  }
}
