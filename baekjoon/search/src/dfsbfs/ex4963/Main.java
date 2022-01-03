package dfsbfs.ex4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
  int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public int solution(int width, int height, int[][] map) {
    int answer = 0;
    boolean[][] isVisited = new boolean[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (!isVisited[row][col] && map[row][col] == 1) {
          isVisited[row][col] = true;
          bfs(row, col, width, height, map, isVisited);
          answer++;
        }
      }
    }

    return answer;
  }

  void bfs(int row, int col, int width, int height, int[][] map, boolean[][] isVisited) {
    Queue<XY> que = new LinkedList<>();
    que.offer(new XY(col, row));

    while (!que.isEmpty()) {
      XY now = que.poll();
      int x = now.x;
      int y = now.y;

      for (int dir = 0; dir < 8; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < width && ny >= 0 && ny < height && !isVisited[ny][nx]
            && map[ny][nx] == 1) {
          isVisited[ny][nx] = true;
          que.offer(new XY(nx, ny));
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    while (true) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      if (w == 0 && h == 0) {
        break;
      }

      int map[][] = new int[h][w];
      for (int y = 0; y < h; y++) {
        String[] strArr = br.readLine().split(" ");
        for (int x = 0; x < w; x++) {
          map[y][x] = Integer.parseInt(strArr[x]);
        }
      }

      bw.write(T.solution(w, h, map) + "\n");
    }
    bw.flush();
    bw.close();
  }
}
