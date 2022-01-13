package dp.ex9461;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public long solution(int n) {
    long answer = 0;
    long[] dp = new long[101];
    for (int i = 1; i <= 3; i++) {
      dp[i] = 1;
    }
    for (int i = 4; i <= 5; i++) {
      dp[i] = 2;
    }

    for (int i = 6; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 5];
    }
    
    answer = dp[n];
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int test = 0; test < t; test++) {
      int n = Integer.parseInt(br.readLine());
      bw.write(T.solution(n) + "\n");
    }
    bw.flush();
    bw.close();
  }
}
