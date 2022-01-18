package ex1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[][] rgb) {
    int answer = 0;
    int[][] dp = new int[n][3];
    for (int i = 0; i < 3; i++) {
      dp[0][i] = rgb[0][i];
    }

    for (int row = 1; row < n; row++) {
      dp[row][0] = Math.min(dp[row - 1][1], dp[row - 1][2]) + rgb[row][0];
      dp[row][1] = Math.min(dp[row - 1][0], dp[row - 1][2]) + rgb[row][1];
      dp[row][2] = Math.min(dp[row - 1][1], dp[row - 1][0]) + rgb[row][2];
    }

    answer = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] rgb = new int[n][3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        rgb[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(T.solution(n, rgb) + "");
    bw.flush();
    bw.close();
  }
}
