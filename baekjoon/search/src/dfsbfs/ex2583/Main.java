package dfsbfs.ex2583;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Rectangle {
  int x1;
  int y1;
  int x2;
  int y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    super();
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
}


public class Main {
  int[][] map;
  int cnt;
  boolean[][] isVisited;
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  public void solution(int width, int height, int n, ArrayList<Rectangle> rectangles) {
    map = new int[height][width];
    isVisited = new boolean[height][width];
    ArrayList<Integer> cntArr = new ArrayList<>();
    
    for (Rectangle rec : rectangles) {
      for (int y = rec.y1; y < rec.y2; y++) {
        for (int x = rec.x1; x < rec.x2; x++) {
          map[y][x] = 1;
        }
      }
    }

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (!isVisited[y][x] && map[y][x] == 0) {
          cnt = 1;
          isVisited[y][x] = true;
          dfs(width, height, x, y);
          cntArr.add(cnt);
        }
      }
    }
    
    Collections.sort(cntArr);
    System.out.println(cntArr.size());
    for (int i : cntArr) {
      System.out.print(i + " ");
    }

  }

  void dfs(int width, int height, int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < width && ny >= 0 && ny < height && !isVisited[ny][nx]
          && map[ny][nx] == 0) {
        isVisited[ny][nx] = true;
        cnt++;
        dfs(width, height, nx, ny);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int height = Integer.parseInt(st.nextToken());
    int width = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    ArrayList<Rectangle> rectangles = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] strArr = br.readLine().split(" ");
      int x1 = Integer.parseInt(strArr[0]);
      int y1 = Integer.parseInt(strArr[1]);
      int x2 = Integer.parseInt(strArr[2]);
      int y2 = Integer.parseInt(strArr[3]);

      rectangles.add(new Rectangle(x1, y1, x2, y2));
    }

    T.solution(width, height, n, rectangles);
  }
}
