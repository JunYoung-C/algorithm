package dfsbfs.ex2667;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  boolean[][] isVisited;
  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};
  ArrayList<Integer> houseCnts = new ArrayList<>();

  public void solution(int n, int[][] map) {
    isVisited = new boolean[n][n];
    int cnt = 0;
    
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (map[row][col] == 1 && !isVisited[row][col]) {
          cnt++;
          int houseCnt = dfs(row, col, n, map) + 1;
          houseCnts.add(houseCnt);
        }
      }
    }
    
    Collections.sort(houseCnts);
    System.out.println(cnt);
    for (int i : houseCnts) {
      System.out.println(i);
    }
  }

  int dfs(int nowRow, int nowCol, int n, int[][] map) {
    isVisited[nowRow][nowCol] = true;
    
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
      int nextRow = nowRow + dy[i];
      int nextCol = nowCol + dx[i];
      if (nextRow >= 0
          && nextRow < n && nextCol >= 0 && nextCol < n && map[nextRow][nextCol] == 1
          && !isVisited[nextRow][nextCol]) {
        cnt += dfs(nextRow, nextCol, n, map) + 1;
      }
    }
    
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      String[] cols = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(cols[j]);
      }
    }

    T.solution(n, map);

  }
}
