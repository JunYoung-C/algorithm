package dfsbfs.ex1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  boolean[] isVisited;

  // n = 정점의 개수, m = 간선의 개수
  public void solution(int n, int m, int start, ArrayList<ArrayList<Integer>> graph) {
    isVisited = new boolean[n + 1];
    dfs(n, start, graph);
    System.out.println();
    isVisited = new boolean[n + 1];
    bfs(n, start, graph);
  }

  void dfs(int n, int now, ArrayList<ArrayList<Integer>> graph) {
    isVisited[now] = true;
    System.out.print(now + " ");

    for (int LinkedNode : graph.get(now)) {
      if (!isVisited[LinkedNode]) {
        dfs(n, LinkedNode, graph);
      }
    }
  }

  void bfs(int n, int start, ArrayList<ArrayList<Integer>> graph) {
    int L = 0;
    Queue<Integer> que = new LinkedList<>();
    que.offer(start);

    while (!que.isEmpty()) {
      int now = que.poll();
      if (isVisited[now]) {
        continue;
      }
      isVisited[now] = true;
      System.out.print(now + " ");
      for (int LinkedNode : graph.get(now)) {
        if (!isVisited[LinkedNode]) {
          que.offer(LinkedNode);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 정점의 개수
    int m = Integer.parseInt(st.nextToken()); // 간선의 개수
    int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

    // 배열
    // int[][] graph = new int[n + 1][n + 1];
    // for (int i = 0; i < m; i++) {
    // st = new StringTokenizer(br.readLine());
    // int a = Integer.parseInt(st.nextToken());
    // int b = Integer.parseInt(st.nextToken());
    // graph[a][b] = 1;
    // graph[b][a] = 1;
    // }

    // for (int[] nodes : graph) {
    // for (int node : nodes) {
    // System.out.print(node + " ");
    // }
    // System.out.println();
    // }

    // arrayList
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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
    
    for (int i = 1; i <= n; i++) {
      Collections.sort(graph.get(i));
    }

    // for (ArrayList<Integer> nodes : graph) {
    // for (int node : nodes) {
    // System.out.print(node + " ");
    // }
    // System.out.println();
    // }
    T.solution(n, m, v, graph);
  }
}
