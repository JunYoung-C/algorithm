package ex2437;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public long solution(int n, int[] weights) {
    long answer = 0L;
    Arrays.sort(weights);
    
    if (weights[0] != 1)
      return 1;
    answer = weights[0] + 1;
    
    for (int i = 1; i < n; i++) {
      if (answer >= weights[i]) {
        answer += weights[i];
      } else {
        return answer;
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      weights[i] = Integer.parseInt(st.nextToken());
    }
    bw.write(T.solution(n, weights) + "");
    bw.flush();
    bw.close();
  }
}

