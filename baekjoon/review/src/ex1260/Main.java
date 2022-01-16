package ex1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  String dfsAns = "";
  String bfsAns = "";
  
  public void solution(int n, int m, int start, ArrayList<ArrayList<Integer>> graph)
      throws IOException {
    boolean[] isVisited = new boolean[n + 1];

    dfs(start, graph, isVisited);
    isVisited = new boolean[n + 1];
    bfs(start, graph, isVisited);
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(dfsAns + "\n" + bfsAns);
    bw.flush();
    bw.close();
  }

  void dfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] isVisited) {
    isVisited[start] = true;
    dfsAns += (start + " ");

    for (int now : graph.get(start)) {
      if (!isVisited[now]) {
        dfs(now, graph, isVisited);
      }
    }
  }
  
  void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] isVisited) {
    isVisited[start] = true;
    bfsAns += (start + " ");
    Queue<Integer> que = new LinkedList<>();
    que.offer(start);
    
    while (!que.isEmpty()) {
      int now = que.poll();
      
      for (int next : graph.get(now)) {
        if (!isVisited[next]) {
          isVisited[next] = true;
          bfsAns += (next + " ");
          que.offer(next);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    int n = Integer.parseInt(st.nextToken()); // 정점의 개수
    int m = Integer.parseInt(st.nextToken()); // 간선의 개수
    int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 0; i <= n; i++) {
      Collections.sort(graph.get(i));
    }
    T.solution(n, m, v, graph);

  }
}
