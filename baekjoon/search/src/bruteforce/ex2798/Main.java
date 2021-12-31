package bruteforce.ex2798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int cardsLen, int m, int[] cards) {
    int answer = Integer.MIN_VALUE;

    for (int i = 0; i < cardsLen; i++) {
      for (int j = i + 1; j < cardsLen; j++) {
        for (int k = j + 1; k < cardsLen; k++) {
          int sum = cards[i] + cards[j] + cards[k];
          if (sum <= m) {
            answer = Integer.max(answer, sum);
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] cards = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    bw.write(T.solution(n, m, cards) + "");
    bw.flush();
    bw.close();
  }
}

