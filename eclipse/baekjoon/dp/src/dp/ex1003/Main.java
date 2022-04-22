package dp.ex1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int[] solution(int n) {
    if (n == 0) {
      return new int[] {1, 0};
    } else if(n == 1) {
      return new int[] {0, 1};
    }
    
    int[] answer = new int[2];
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n - 1; i++) {
      dp[i] = dp[i-1] + dp[i - 2];
    }
    
    answer[0] = dp[n - 2];
    answer[1] = dp[n - 1];
    
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int t = Integer.parseInt(br.readLine());
    for (int test = 0; test < t; test++) {
      int n = Integer.parseInt(br.readLine());
      for (int i : T.solution(n)) {
        bw.write(i+ " ");
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }
}
