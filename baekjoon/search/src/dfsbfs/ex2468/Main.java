package dfsbfs.ex2468;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int solution(int n, int max, int[][] map) {
    int answer = 0;

    for (int h = 0; h <= max; h++) {
      answer = Math.max(answer, countSafeZone(h, n, map));
    }

    return answer;
  }

  int countSafeZone(int h, int n, int[][] map) {
    int cnt = 0;
    boolean[][] isVisited = new boolean[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (map[y][x] > h && !isVisited[y][x]) {
          isVisited[y][x] = true;
          cnt++;
          dfs(x, y, h, n, map, isVisited);
        }
      }
    }


    return cnt;

  }

  void dfs(int nowX, int nowY, int h, int n, int[][] map, boolean[][] isVisited) {
    for (int i = 0; i < 4; i++) {
      int nx = nowX + dx[i];
      int ny = nowY + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] > h && !isVisited[ny][nx]) {
        isVisited[ny][nx] = true;
        dfs(nx, ny, h, n, map, isVisited);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());

    int[][] map = new int[n][n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] > max) {
          max = map[i][j];
        }
      }
    }

    bw.write(T.solution(n, max, map) + "");
    bw.flush();
    bw.close();
  }
}
