package array.ex10;

import java.util.Scanner;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int solution(int n, int[][] map) {
    int answer = 0;
    for (int y = 1; y <= n; y++) {
      for (int x = 1; x <= n; x++) {
        boolean isBig = true;

        for (int dir = 0; dir < 4; dir++) {
          int nx = x + dx[dir];
          int ny = y + dy[dir];
          if (map[y][x] <= map[ny][nx]) {
            isBig = false;
          }
        }

        if (isBig) {
          answer++;
        }
      }
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();

    int[][] map = new int[n + 2][n + 2];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, map));
  }
}
