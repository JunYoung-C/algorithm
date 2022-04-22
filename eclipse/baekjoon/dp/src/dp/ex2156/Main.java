package dp.ex2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int solution(int n, int[] cups) {
    if (n == 1) {
      return cups[1];
    }
    if (n == 2) {
      return cups[1] + cups[2];
    }
    int answer = 0;
    int[] dp = new int[n + 1];
    
    dp[1] = cups[1];
    dp[2] = cups[1] + cups[2];
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + cups[i - 1]) + cups[i]);
    }
    
    for (int i : dp) {
      if (answer < i) {
        answer = i;
      }
    }
    
//    for (int i : dp) {
//      System.out.print(i + " ");
//    }
//    System.out.println();
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] cups = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      cups[i] = Integer.parseInt(br.readLine());
    }
    
    bw.write(T.solution(n, cups)+ "");
    bw.flush();
    bw.close();
  }
}
