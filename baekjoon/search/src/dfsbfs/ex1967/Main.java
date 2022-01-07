package dfsbfs.ex1967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
  int v;
  int cost;

  public Node(int v, int cost) {
    super();
    this.v = v;
    this.cost = cost;
  }
}


public class Main {
  int answer = 0;

  public int solution(int n, ArrayList<ArrayList<Node>> graph) {
    boolean[] isVisited = new boolean[n + 1];

    for (int node = 1; node <= n; node++) {
      if (graph.get(node).size() != 1) { // 말단 노드가 아니면 스킵
        continue;
      }

      isVisited[node] = true;
      dfs(0, node, node, graph, isVisited);
      isVisited[node] = false;
    }
    return answer;
  }

  void dfs(int sum, int start, int now, ArrayList<ArrayList<Node>> graph, boolean[] isVisited) {
    if (start != now && graph.get(now).size() == 1) {
      answer = Math.max(answer, sum);
      return;
    }

    for (Node next : graph.get(now)) {
      if (!isVisited[next.v]) {
        isVisited[next.v] = true;
        dfs(sum + next.cost, start, next.v, graph, isVisited);
        isVisited[next.v] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }


    bw.write(T.solution(n, graph) + "");
    bw.flush();
    bw.close();
  }
}
