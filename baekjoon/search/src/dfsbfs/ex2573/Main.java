package dfsbfs.ex2573;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public int solution(int width, int height, int[][] map) {
    int answer = 0;
    int year = 0;
    boolean[][] isVisited;
    boolean allMelted = false;

    while (true) {
      isVisited = new boolean[height][width];
      
      // 빙산 녹이기
      allMelted = meltIce(width, height, map);
      if (allMelted) {
        break;
      }
      
//      for (int[] rows : map) {
//        for (int c : rows) {
//          System.out.print(c + " ");
//        }
//        System.out.println();
//      }
//      System.out.println();
      // dfs
      int cnt = 0;
      for (int y = 1; y < height - 1; y++) {
        for (int x = 1; x < width - 1; x++) {
          if (map[y][x] != 0 && !isVisited[y][x]) {
            cnt++;
            isVisited[y][x] = true;
            dfs(x, y, width, height, map, isVisited);
          }
        }
      }
      
      year++;
      if (cnt >= 2) {
        answer = year;
        break;
      }
    }


    return answer;
  }

  private void dfs(int x, int y, int width, int height, int[][] map, boolean[][] isVisited) {
    for (int dir = 0; dir < 4; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] != 0
          && !isVisited[ny][nx]) {
        isVisited[ny][nx] = true;
        dfs(nx, ny, width, height, map, isVisited);
      }
    }
  }

  private boolean meltIce(int width, int height, int[][] map) {
    boolean allMelted = true;
    int[][] copyMap = copyMap(width, height, map);
    
    for (int y = 1; y < height - 1; y++) {
      for (int x = 1; x < width - 1; x++) {
        if (map[y][x] != 0) {
          allMelted = false;
          map[y][x] -= countArroundIce(x, y, copyMap);
          if (map[y][x] < 0) {
            map[y][x] = 0;
          }
        }
      }
    }

    return allMelted;
  }

  private int[][] copyMap(int width, int height, int[][] map) {
    int[][] copyMap = new int[height][width];
    
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        copyMap[y][x] = map[y][x];
      }
    }
    
    return copyMap;
  }
  private int countArroundIce(int x, int y, int[][] map) {
    int cnt = 0;

    for (int dir = 0; dir < 4; dir++) {
      int nx = x + dx[dir];
      int ny = y + dy[dir];
      if (map[ny][nx] == 0) {
        cnt++;
      }
    }

    return cnt;
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

    bw.write(T.solution(width, height, map) + "");
    bw.flush();
    bw.close();
  }
}
