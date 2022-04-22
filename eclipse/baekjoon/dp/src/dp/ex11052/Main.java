package dp.ex11052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[] cards) {
    int answer = 0;
    int[] dp = cards.clone();
    
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i - 1; j++) {
        dp[i] = Math.max(dp[i], cards[j] + dp[i - j]);
      }
    }
    
    answer = dp[n];
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] cards = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    bw.write(T.solution(n, cards)+ "");
    bw.flush();
    bw.close();
  }
}
