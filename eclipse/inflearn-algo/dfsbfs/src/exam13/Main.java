package exam13;

import java.util.Scanner;

class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


public class Main {
  static int n;
  static int[][] map, dis;
  int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public void dfs(int y, int x) {
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == 1 && dis[ny][nx] == 0) {
        dis[ny][nx] = 1;
        dfs(ny, nx);
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    map = new int[n][n];
    dis = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && dis[i][j] == 0) {
          dis[i][j] = 1;
          answer++;
          T.dfs(i, j);
        }
      }
    }

    System.out.println(answer);
  }
}
