package exam11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XY {
  int x;
  int y;
  XY(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
public class Main {
  static int[][] map = new int[8][8];
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  public int bfs() {
    int L = 0;
    Queue<XY> que = new LinkedList<>();
    que.offer(new XY(1, 1));
    while (!que.isEmpty()) {
      int len = que.size();
      for (int j = 0; j < len; j++) {
        XY xy = que.poll();
        for (int i = 0; i < 4; i++) {
          int nx = xy.x + dx[i];
          int ny = xy.y + dy[i];
          if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0 ) {
            if (nx == 7 && ny == 7) {
              return L + 1;
            }
            
            map[nx][ny] = 1;
            que.offer(new XY(nx, ny));
          }
        }
      }
      
      L++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    for (int i = 1; i < 8; i++) {
      for (int j = 1; j < 8; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.bfs());
  }
}
