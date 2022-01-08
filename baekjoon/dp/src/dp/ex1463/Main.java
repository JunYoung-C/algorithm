package dp.ex1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      }
      
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      }

      dp[i] = Math.min(dp[i], dp[i - 1] + 1);

    }

    answer = dp[n];
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
