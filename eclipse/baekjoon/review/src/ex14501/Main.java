package ex14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[] times, int[] points) {
    int answer = 0;
    int[] dp = new int[n + 1];
    
    for (int day = 1; day <= n; day++) {
      int nowTime = times[day];
      int nowPoint = points[day];
      
      for (int start = day + nowTime - 1; start <= n; start++) {
        dp[start] =  Math.max(dp[start], dp[day - 1] + nowPoint);
      }
    }
    
    answer = dp[n];
    
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[] times = new int[n + 1];
    int[] points = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      times[i] = t;
      points[i] = p;
    }
    
    bw.write(T.solution(n, times, points)+ "");
    bw.flush();
    bw.close();
  }
}

