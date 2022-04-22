package dfsbfs.ex10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int[] solution(int n, char[][] map) {
    int[] answer = new int[2]; // {적록색약 x, 적록색약 o}

    answer[0] = countZone(false, n, map);
    answer[1] = countZone(true, n, map);

    return answer;
  }

  int countZone(boolean hasWeakness, int n, char[][] map) {
    int cnt = 0;
    boolean[][] isVisited = new boolean[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (!isVisited[y][x]) {
          isVisited[y][x] = true;
          cnt++;
          dfs(hasWeakness, x, y, n, map, isVisited);
        }
      }
    }

    return cnt;
  }

  void dfs(boolean hasWeakness, int x, int y, int n, char[][] map, boolean[][] isVisited) {
    char nowColor = map[y][x];

    for (int dir = 0; dir < 4; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      
      if (nx < 0 || nx >= n || ny < 0 || ny >= n || isVisited[ny][nx]) {
        continue;
      }

      char nextColor = map[ny][nx];
      
      if (hasWeakness) {
        if (nowColor == 'B' && nextColor == 'B') {
          isVisited[ny][nx] =true;
          dfs(hasWeakness, nx, ny, n, map, isVisited);
        }
        
        if (nowColor != 'B' && (nextColor == 'R' || nextColor == 'G')) {
          isVisited[ny][nx] =true;
          dfs(hasWeakness, nx, ny, n, map, isVisited);
        }
      } else {
        if (nowColor == nextColor) {
          isVisited[ny][nx] =true;
          dfs(hasWeakness, nx, ny, n, map, isVisited);
        }
      }
      
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    char[][] map = new char[n][n];

    for (int i = 0; i < n; i++) {
      char[] charArr = br.readLine().toCharArray();

      for (int j = 0; j < n; j++) {
        map[i][j] = charArr[j];
      }
    }

    for (int i : T.solution(n, map)) {
      bw.write(i + " ");
    }
    bw.flush();
    bw.close();
  }
}
