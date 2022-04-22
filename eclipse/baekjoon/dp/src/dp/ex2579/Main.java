package dp.ex2579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(int n, int[] steps) {
    if (n == 1) {
      return steps[1];
    }
    if (n == 2) {
      return steps[1] + steps[2];
    }
    int answer = 0;
    int[] dp = new int[n + 1];
    dp[1] = steps[1];
    dp[2] = steps[1] + steps[2];
    
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2],  dp[i - 3] + steps[i - 1]) + steps[i];
    }
    
    answer = dp[n];
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] steps = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
      steps[i] = Integer.parseInt(br.readLine());
    }
    bw.write(T.solution(n, steps)+ "");
    bw.flush();
    bw.close();
  }
}
