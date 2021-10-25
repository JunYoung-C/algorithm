package exam09;

import java.util.Scanner;

public class Main {
  static int answer = 0;
  static int[][] map = new int[7][7];
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  public void dfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && map[nx][ny] == 0 ) {
        if (nx == 6 && ny == 6) {
          answer++;
          continue;
        }
        map[nx][ny] = 1;
        dfs(nx, ny);
        map[nx][ny] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    map[0][0] = 1;
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
