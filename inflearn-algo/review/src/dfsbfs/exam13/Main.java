package dfsbfs.exam13;

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
  static int answer = 0;
  static int[][] map, ch;
  static int n;
  int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
  public void dfs(int x, int y) {
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == 1 && ch[ny][nx] == 0) {
        ch[ny][nx] = 1;
        dfs(nx, ny);
      }
    }
    
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    map = new int[n][n];
    ch = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (map[y][x] == 1 && ch[y][x] == 0 ) {
          answer++;
          T.dfs(x, y);
        }
      }
    }
    System.out.println(answer);
  }
}
