package dfsbfs.exam11;

import java.util.LinkedList;
import java.util.Queue;
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
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int bfs(int[][] map, int[][] dist) {
    Queue<Point> que = new LinkedList<>();
    que.offer(new Point(0, 0));
    while (!que.isEmpty()) {
      Point point = que.poll();
      for (int i = 0; i < 4; i++) {
        int nx = point.x + dx[i];
        int ny = point.y + dy[i];
        if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && dist[ny][nx] == 0 && map[ny][nx] == 0) {
          dist[ny][nx] = dist[point.y][point.x] + 1;
          que.offer(new Point(nx, ny));
        }
        if (nx == 6 && ny == 6) {
          return dist[ny][nx];
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int[][] map = new int[7][7];
    int[][] ch = new int[7][7];
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.bfs(map, ch));

  }
}
