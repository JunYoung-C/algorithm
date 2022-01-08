package dp.ex9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  int[] dp;
  public int solution(int n) {
    int answer = 0;
    dp = new int[11]; 
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= 10; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i - 3];
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
      bw.write(T.solution(n)+ "\n");
    }
    bw.flush();
    bw.close();
  }
}
