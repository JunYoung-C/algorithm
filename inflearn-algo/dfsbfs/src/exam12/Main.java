package exam12;

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
  static int[][] board;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static Queue<Point> que = new LinkedList<>();
  public int bfs(int n, int m) {
    int L = -1;
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        Point point = que.poll();
        for (int j = 0; j < 4; j++) {
          int nx = point.x + dx[j];
          int ny = point.y + dy[j];
          if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && board[ny][nx] == 0) {
            board[ny][nx] = 1;
            que.offer(new Point(nx, ny));
          }
        }
      }
      L++;
    }
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (board[i][j] == 0) return -1;
      }
    }
    
    return L ;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int m = stdIn.nextInt();
    int n = stdIn.nextInt();
    board = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        board[i][j] = stdIn.nextInt();
        if (board[i][j] == 1) {
          que.offer(new Point(j, i));
        }
      }
    }
    
    System.out.println(T.bfs(n, m));
  }
}
