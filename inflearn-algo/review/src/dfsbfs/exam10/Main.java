package dfsbfs.exam10;

import java.util.Scanner;

public class Main {
  static int answer = 0;
  static int[][] map, ch;
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public void dfs(int x, int y) {
    if(x == 6 && y == 6) {
      answer++;
    } else {
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && ch[ny][nx] == 0 && map[ny][nx] == 0) {
          ch[ny][nx] = 1;
          dfs(nx, ny);
          ch[ny][nx] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    map = new int[7][7];
    ch = new int[7][7];
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    ch[0][0] = 1;
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
