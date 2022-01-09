package dp.ex11726;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    int answer = 0;
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }

    answer = dp[n] ;
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
