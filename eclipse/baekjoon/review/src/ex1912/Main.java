package ex1912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[] numbers) {
    int answer = 0;
    int[] dp = new int[n];
    dp[0] = numbers[0];
    
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(numbers[i], dp[i - 1] + numbers[i]);
    }
    
    answer = Arrays.stream(dp).max().getAsInt();
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    bw.write(T.solution(n, numbers) + "");
    bw.flush();
    bw.close();
  }
}
