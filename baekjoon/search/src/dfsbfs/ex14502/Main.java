package dfsbfs.ex14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

  static ArrayList<XY> virusArr = new ArrayList<>();

  public int solution(int width, int height, int[][] map) {
    int answer = 0;
    int[][] copyMap = map.clone();

    // 벽 3개를 경우의 수로 깔아보고 각각 bfs/dfs를 실행한 후 최솟값을 구한다.
    answer = bfsWithThreeWall(width, height, copyArray(map));

    return answer;
  }

  int[][] copyArray(int[][] arr) {
    int[][] answer = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      answer[i] = arr[i].clone();
    }
    
    return answer;
  }
  int bfsWithThreeWall(int width, int height, int[][] map) {
    int max = 0;

    for (int row1 = 0; row1 < height; row1++) {
      for (int col1 = 0; col1 < width; col1++) {
        if (map[row1][col1] != 0) {
          continue;
        }

        map[row1][col1] = 1;
        for (int row2 = 0; row2 < height; row2++) {
          for (int col2 = 0; col2 < width; col2++) {
            if (map[row2][col2] != 0) {
              continue;
            }

            map[row2][col2] = 1;
            for (int row3 = 0; row3 < height; row3++) {
              for (int col3 = 0; col3 < width; col3++) {
                if (map[row3][col3] != 0) {
                  continue;
                }
                map[row3][col3] = 1;
                max = Math.max(max, countSafeZone(width, height, copyArray(map)));
//                for (int[] i : map) {
//                  for (int j : i) {
//                    System.out.print(j + " ");
//                  }
//                  System.out.println();
//                }
//                System.out.println();
                map[row3][col3] = 0;
              }
            }

            map[row2][col2] = 0;
          }
        }

        map[row1][col1] = 0;
      }
    }

    return max;
  }

  int countSafeZone(int width, int height, int[][] map) {
    int cnt = 0;
    // 바이러스 퍼지게하기
    bfs(width, height, map);


    // 안전구역 카운팅
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (map[row][col] == 0) {
          cnt++;
        }
        
      }
    }

    return cnt;
  }

  void bfs(int width, int height, int[][] map) {
    Queue<XY> que = new LinkedList<>();
    for (XY virus : virusArr) {
      que.offer(new XY(virus.x, virus.y));
    }

    // 테스트용 벽 설치
//    map[0][1] = 1;
//    map[1][0] = 1;
//    map[3][5] = 1;
    
    while (!que.isEmpty()) {
      XY now = que.poll();
      int y = now.y;
      int x = now.x;

      for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < width && ny >= 0 && ny < height && map[ny][nx] == 0) {
          map[ny][nx] = 2;
          que.offer(new XY(nx, ny));
        }
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

    int[][] map = new int[height][width];
    for (int y = 0; y < height; y++) {
      String[] strArr = br.readLine().split(" ");
      for (int x = 0; x < width; x++) {
        map[y][x] = Integer.parseInt(strArr[x]);
        if (map[y][x] == 2) {
          virusArr.add(new XY(x, y));
        }
      }
    }
    bw.write(T.solution(width, height, map) + "");
//    bw.write(T.countSafeZone(width, height, map) + "");

    bw.flush();
    bw.close();
  }
}
