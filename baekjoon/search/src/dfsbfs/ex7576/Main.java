package dfsbfs.ex7576;

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

  public int solution(int width, int height, int[][] map, Queue<XY> que) {
    int answer = -1;
    int[][] copyMap = map.clone();
    
    while (!que.isEmpty()) {
      int len = que.size();
      
      for (int i = 0; i < len; i++) {
        XY now = que.poll();
        for (int dir = 0; dir < 4; dir++) {
          int nx = now.x + dx[dir];
          int ny = now.y + dy[dir];
          if (nx >= 0 && nx < width && ny>= 0 && ny < height && copyMap[ny][nx] == 0) {
            copyMap[ny][nx] = 1;
            que.offer(new XY(nx, ny));
          }
        }
      }
      
      answer++;
    }
    
    for (int[] rows : map) {
      for (int col : rows) {
        if (col == 0) {
          return -1;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int width = Integer.parseInt(st.nextToken());
    int height = Integer.parseInt(st.nextToken());
    int[][] map = new int[height][width];
    Queue<XY> que = new LinkedList<>();

    for (int row = 0; row < height; row++) {
      String[] strArr = br.readLine().split(" ");
      for (int col = 0; col < width; col++) {
        map[row][col] = Integer.parseInt(strArr[col]);
        if (map[row][col] == 1) {
          que.offer(new XY(col, row));
        }
      }
    }
    bw.write(T.solution(width, height, map, que) + "");
    bw.flush();
    bw.close();
  }
}
