package ex11047;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int k, int[] coins) {
    int[] dp = new int[k + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    
    for (int coin : coins) {
      for (int i = coin; i <= k; i++) {
        dp[i] = Math.min(dp[i], dp[i-coin] + 1);
      }
    }
    
    return dp[k];
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(input.readLine());
    }

    print.write(T.solution(n, k, coins) + "");
    print.flush();
    print.close();
  }
}

