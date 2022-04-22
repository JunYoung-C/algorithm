package dp.ex10844;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public long solution(int n) {
    long answer = 0;
    long[][] dp = new long[n][10];
    for (int i = 1; i < 10; i++) {
      dp[0][i] = 1;
    }

    for (int row = 1; row < n; row++) {
      for (int col = 0; col < 10; col++) {
        long lt = 0;
        if (col - 1 >= 0) {
          lt = dp[row - 1][col - 1];
        }

        long rt = 0;
        if (col + 1 < 10) {
          rt = (dp[row - 1][col + 1]) % 1000000000;
        }
        dp[row][col] = lt + rt;
      }
    }

    answer = (Arrays.stream(dp[n - 1]).sum()) % 1000000000;
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
