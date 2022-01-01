package dfsbfs.ex1012;

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
  boolean[][] isVisited;
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int solution(int width, int height, int n, int[][] map) {
    int answer = 0;
    isVisited = new boolean[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (!isVisited[y][x] && map[y][x] == 1) {
          answer++;
          bfs(x, y, width, height, n, map);
        }
      }
    }
    return answer;
  }

  void bfs(int x, int y, int width, int height, int n, int[][] map) {
    isVisited[y][x] = true;
    Queue<XY> que = new LinkedList<>();
    que.offer(new XY(x, y));

    while (!que.isEmpty()) {
      XY now = que.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] == 1
            && !isVisited[ny][nx]) {
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
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());

      int width = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int[][] map = new int[height][width];

      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        map[row][col] = 1;
      }

      bw.write(T.solution(width, height, n, map) + "\n");
    }

    bw.flush();
    bw.close();
  }
}
