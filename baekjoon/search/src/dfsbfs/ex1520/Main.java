package dfsbfs.ex1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
  int x;
  int y;

  public XY(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }
}


public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  int[][] dp;

  public int solution(int width, int height, int[][] map) {
    dp = new int[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        dp[y][x] = -1;
      }
    }
    dfs(0, 0, width, height, map);
    return dp[0][0];
  }

  int dfs(int x, int y, int width, int height, int[][] map) {

    if (x == width - 1 && y == height - 1) {
      return 1;
    }

    if (dp[y][x] != -1) {
      return dp[y][x];
    }

    dp[y][x] = 0;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[y][x] > map[ny][nx]) {
        dp[y][x] += dfs(nx, ny, width, height, map);
      }
    }
    return dp[y][x];
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    int[][] map = new int[height][width];

    for (int y = 0; y < height; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < width; x++) {
        map[y][x] = Integer.parseInt(st.nextToken());
      }
    }
    // int num = 10000;
    // for (int y = 0; y < height; y++) {
    // for (int x = 0; x < width; x++) {
    // map[y][x] = num--;
    // }
    // }
    bw.write(T.solution(width, height, map) + "");
    bw.flush();
    bw.close();
  }
}
