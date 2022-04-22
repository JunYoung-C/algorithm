package dfsbfs.ex1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  boolean[] isVisited = new boolean['Z' - 'A' + 1];
  int answer = 0;

  public int solution(int width, int height, char[][] board) {
    isVisited[board[0][0] - 'A'] = true;
    dfs(1, 0, 0, width, height, board);
    return answer;
  }

  void dfs(int L, int nowX, int nowY, int width, int height, char[][] board) {
    boolean noWay = true;
    for (int dir = 0; dir < 4; dir++) {
      int nx = nowX + dx[dir];
      int ny = nowY + dy[dir];

      if (nx >= 0 && nx < width && ny >= 0 && ny < height && !isVisited[board[ny][nx] - 'A']) {
        noWay = false;
        isVisited[board[ny][nx] - 'A'] = true;
        dfs(L + 1, nx, ny, width, height, board);
        isVisited[board[ny][nx] - 'A'] = false;
      }
    }

    if (noWay) {
      answer = Math.max(answer, L);
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    char[][] board = new char[height][width];
    for (int y = 0; y < height; y++) {
      char[] charArr = br.readLine().toCharArray();
      for (int x = 0; x < width; x++) {
        board[y][x] = Character.toUpperCase(charArr[x]);
      }
    }

    bw.write(T.solution(width, height, board) + "");
    bw.flush();
    bw.close();
  }
}
