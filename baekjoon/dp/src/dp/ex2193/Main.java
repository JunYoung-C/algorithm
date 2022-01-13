package dp.ex2193;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public long solution(int n) {
    long answer = 0;
    long[][] dp = new long[n + 1][2];
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i][0] += dp[i - 1][0] + dp[i - 1][1];
      dp[i][1] += dp[i - 1][0];
    }

    for (long num : dp[n]) {
      answer += num;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    bw.write(T.solution(n) + "");
    bw.flush();
    bw.close();
  }
}
