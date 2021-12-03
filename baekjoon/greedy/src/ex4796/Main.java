package ex4796;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public int solution(int l, int p, int v) {
    int answer = 0;

    while (v > 0) {
      if (v >= l) {
        answer += l;
      } else {
        answer += v;
      }
      v -= p;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = 1;
    while (true) {
      st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      if (L == 0 && P == 0 && V == 0) break;
      bw.write("Case " + n + ": " + T.solution(L, P, V) + "\n");
      n++;
    }

    bw.flush();
    bw.close();
  }
}

