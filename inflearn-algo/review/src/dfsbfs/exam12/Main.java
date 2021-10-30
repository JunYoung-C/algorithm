package dfsbfs.exam12;

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
  static Queue<Point> que = new LinkedList<>();
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  public int bfs(int width, int height, int[][] board) {
    int answer = -1;
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        Point point = que.poll();
        for (int j = 0; j < 4; j++) {
          int nx = point.x + dx[j];
          int ny = point.y + dy[j];
          if (nx >= 0 && nx < width && ny >= 0 && ny < height && board[ny][nx] == 0) {
            board[ny][nx] = 1;
            que.offer(new Point(nx, ny));
          }
        }
      }
      answer++;
    }
    
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (board[row][col] == 0) return -1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int width = stdIn.nextInt();
    int height = stdIn.nextInt();
    int[][] board = new int[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        board[row][col] = stdIn.nextInt();
        if (board[row][col] == 1) {
          que.offer(new Point(col, row));
        }
      }
    }
    System.out.println(T.bfs(width, height, board));
  }
}
