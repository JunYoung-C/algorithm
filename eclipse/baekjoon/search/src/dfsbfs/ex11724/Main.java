package dfsbfs.ex11724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  void unite(int a, int b, int[] unf) {
    int fa = find(a, unf);
    int fb = find(b, unf);
    
    if (fa != fb) {
      unf[fa] = fb;
    }
  }

  int find(int a, int[] unf) {
    if (unf[a] == a) {
      return a;
    } else {
      return unf[a] = find(unf[a], unf);
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // 정점의 개수
    int m = Integer.parseInt(st.nextToken()); // 간선의 개수

    int[] unf = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      unf[i] = i;
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      T.unite(a, b, unf);
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      int fi = T.find(i, unf);
      if (fi == i) {
        cnt++;
      }
    }
    
//    for (int i : unf) {
//      System.out.print(i + " ");
//    }
    bw.write(cnt + "");
    bw.flush();
    bw.close();
  }
}
