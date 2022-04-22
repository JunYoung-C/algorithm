package ex1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  boolean[][] isVisited;
  
  public int solution(int width, int height, int[][] map) {
    int answer = 0;
    int[][] copyMap = new int[height][width];
    isVisited = new boolean[height][width];
    
    isVisited[0][0] = true;
    dfs(0, 0, width, height, map, copyMap);

//    for (int y = 0; y < height; y++) {
//      for (int x = 0; x < width; x++) {
//        System.out.print(copyMap[y][x] + " ");
//      }
//      System.out.println();
//    }
    answer = copyMap[0][0];
    return answer;
  }

  int dfs(int x, int y, int width, int height, int[][] map, int[][] copyMap) {
    if (x == width - 1 && y == height - 1) {
      copyMap[y][x] += 1;
      return 1;
    }

    int nx, ny;
    for (int dir = 0; dir < 4; dir++) {
      ny = y + dy[dir];
      nx = x + dx[dir];

      if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
        continue;
      }


      if (map[y][x] > map[ny][nx]) {
        if (isVisited[ny][nx] && map[ny][nx] != 0) { // 방문했지만 끝에 도달 못한 경우 고려
          copyMap[y][x] += copyMap[ny][nx];
        } 
        if (!isVisited[ny][nx]) {
//          for (int y1 = 0; y1 < height; y1++) {
//            for (int x1 = 0; x1 < width; x1++) {
//              System.out.print(copyMap[y1][x1] + " ");
//            }
//            System.out.println();
//          }
//          System.out.println();
          isVisited[ny][nx] = true;
          copyMap[y][x] += dfs(nx, ny, width, height, map, copyMap);
        }
      }
    }

    return copyMap[y][x];
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
