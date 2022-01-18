package ex2644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  boolean[] isVisited;
  boolean isFind = false;
  int answer = -1;

  public int solution(int n, int m, int start, int end, ArrayList<ArrayList<Integer>> graph) {
    isVisited = new boolean[n + 1];
    dfs(start, end, 0, graph);

    return answer;
  }

  void dfs(int now, int end, int L, ArrayList<ArrayList<Integer>> graph) {
    if (isFind) {
      return;
    }

    for (int next : graph.get(now)) {
      if (next == end) {
        answer = L + 1;
        isFind = true;
        return;
      }
      if (!isVisited[next]) {
        isVisited[next] = true;
        dfs(next, end, L + 1, graph);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());

    ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    bw.write(T.solution(n, m, start, end, graph) + "");
    bw.flush();
    bw.close();
  }
}
