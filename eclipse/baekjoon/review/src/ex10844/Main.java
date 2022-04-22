package ex10844;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int div = 1000000000;
    int[][] dp = new int[n + 1][10];

    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int row = 2; row <= n; row++) {
      for (int col = 0; col <= 9; col++) {
        int lt = 0;
        if (col - 1 >= 0) {
          lt = dp[row - 1][col - 1];
        }
        int rt = 0;
        if (col + 1 <= 9) {
          rt = dp[row - 1][col + 1];
        }
        dp[row][col] = (lt + rt) % div;
      }
    }
    for (int i = 0; i <= 9; i++) {
      answer = (answer + dp[n][i]) % div;
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
