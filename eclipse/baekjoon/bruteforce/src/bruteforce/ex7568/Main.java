package bruteforce.ex7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {
  public int[] solution(int n, int[] weights, int[] heights) {
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      int rank = 1;
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        
        if (weights[i] < weights[j] && heights[i] < heights[j]) {
          rank++;
        }
      }
      
      answer[i] = rank;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] weights = new int[n];
    int[] heights = new int[n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i] = Integer.parseInt(st.nextToken());
      heights[i] = Integer.parseInt(st.nextToken());
    }

    for (int i : T.solution(n, weights, heights)) {
      bw.write(i + " ");
    }
    bw.flush();
    bw.close();
  }
}

