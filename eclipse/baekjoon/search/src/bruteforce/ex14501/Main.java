package bruteforce.ex14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[] t, int[] p) {
    int answer = 0;
    int[] days = new int[n + 1];
    
    for (int i = 0; i < n; i++) {
      int yesterday = i;
      int today = i + 1;
      int endDay = today + t[i] - 1;
      for (int j = endDay; j <= n; j++) {
        days[j] = Math.max(days[yesterday] + p[i], days[j]);
      }
      
    }
    
    answer = days[n];
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[] t = new int[n];
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }
    
    bw.write(T.solution(n, t, p)+ "");
    bw.flush();
    bw.close();
  }
}

