package dp.ex9465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[][] stickers) {
    int answer = 0;
    int[][] dp = new int[2][n + 1];
    dp[0][1] = stickers[0][1];
    dp[1][1] = stickers[1][1];

    for (int i = 2; i <= n; i++) {
      dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 2], dp[1][i - 1]);
      dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 2], dp[0][i - 1]);
    }

      answer = Math.max(Math.max(dp[0][n], dp[1][n]), Math.max(dp[0][n - 1], dp[1][n - 1])) ;
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for (int test = 0; test < t; test++) {
      int n = Integer.parseInt(br.readLine());
      int[][] stickers = new int[2][n + 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        stickers[0][i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        stickers[1][i] = Integer.parseInt(st.nextToken());
      }

      bw.write(T.solution(n, stickers) + "\n");
    }
    
    bw.flush();
    bw.close();
  }
}
