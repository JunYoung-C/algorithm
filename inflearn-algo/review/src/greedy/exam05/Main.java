package greedy.exam05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
  int vex;
  int cost;

  public Node(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}


public class Main {
  static int n, m;
  static ArrayList<ArrayList<Node>> graph;
  static int[] dis;
  public void solution(int v) {
    PriorityQueue<Node> pQ = new PriorityQueue<>();
    pQ.offer(new Node(v, 0));
    dis[v] = 0;
    while (!pQ.isEmpty()) {
      Node tmp = pQ.poll();
      int now = tmp.vex;
      int nowCost = tmp.cost;
      if (dis[now] < nowCost) continue;
      for (Node node : graph.get(now)) {
        if (dis[node.vex] > nowCost + node.cost) {
          dis[node.vex] = nowCost + node.cost;
          pQ.offer(new Node(node.vex, nowCost + node.cost));
        }
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    graph = new ArrayList<>();
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }
    dis = new int[n + 1];
    Arrays.fill(dis, Integer.MAX_VALUE);
    
    for (int i = 0; i < m; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      int cost = stdIn.nextInt();
      graph.get(a).add(new Node(b, cost));
    }
    
    T.solution(1);
    for (int i = 2; i < n; i++) {
      if (dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
      else System.out.println(i + " : impossible");
    }
  }
}

/*
 * 
6 9
1 2 12 
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 * 
 */
 
