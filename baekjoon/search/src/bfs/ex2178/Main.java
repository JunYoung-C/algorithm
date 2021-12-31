package bfs.ex2178;

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
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  boolean[][] isVisited;

  public int solution(int width, int height, int[][] map) {
    int answer = 0;
    isVisited = new boolean[height][width];
    Queue<XY> que = new LinkedList<>();
    int L = 1;
    que.offer(new XY(0, 0));


    int[][] clone = map.clone();

    while (!que.isEmpty()) {
      int len = que.size();
      XY xy = que.poll();


      int x = xy.x;
      int y = xy.y;
      if (isVisited[y][x]) {
        continue;
      }
      isVisited[y][x] = true;
      for (int direction = 0; direction < 4; direction++) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] == 1
            && !isVisited[ny][nx]) {
          clone[ny][nx] =clone[y][x] + 1;
          que.offer(new XY(nx, ny));
        }
      }
      // for (int i = 0; i < len; i++) {
      // XY xy = que.poll();
      // int x = xy.x;
      // int y = xy.y;
      // if (isVisited[y][x]) {
      // continue;
      // }
      // isVisited[y][x] = true;
      //
      // for (int direction = 0; direction < 4; direction++) {
      // int nx = x + dx[direction];
      // int ny = y + dy[direction];
      // if (ny == height - 1 && nx == width - 1) {
      // return L + 1;
      // }
      // if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] == 1
      // && !isVisited[ny][nx]) {
      // que.offer(new XY(nx, ny));
      // }
      // }
//      L++;
    }

    answer = clone[height-1][width-1];
    return answer;

  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    int[][] map = new int[height][width];
    for (int row = 0; row < height; row++) {
      String[] strArr = br.readLine().split("");
      for (int col = 0; col < width; col++) {
        map[row][col] = Integer.parseInt(strArr[col]);
      }
    }

    bw.write(T.solution(width, height, map) + "");
    bw.flush();
    bw.close();
  }
}
