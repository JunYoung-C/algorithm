package ex1967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
  int maxIndex = 0;
  int maxDis = 0;
  boolean[] isVisited;

  public int solution(int n, ArrayList<ArrayList<Node>> graph) {
    int answer = 0;
    isVisited = new boolean[n + 1];
    
    // 가장 멀리있는 노드 찾기
    isVisited[1] = true;
    dfs(1, 0, n, graph);

    // 가장 긴 노드를 시작으로 dfs
    isVisited = new boolean[n + 1];
    maxDis = 0;
    isVisited[maxIndex] = true;
    dfs(maxIndex, 0, n, graph);

    answer = maxDis;
    return answer;
  }

  void dfs(int nowIndex, int sum, int n, ArrayList<ArrayList<Node>> graph) {
    boolean hasChild = false;

    for (Node child : graph.get(nowIndex)) {
      if (!isVisited[child.v]) {
        hasChild = true;
        isVisited[child.v] = true;
        dfs(child.v, sum + child.cost, n, graph);
      }
    }

    if (!hasChild) {
      if (maxDis < sum) {
        maxDis = sum;
        maxIndex = nowIndex;
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
      graph.add(new ArrayList());
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
