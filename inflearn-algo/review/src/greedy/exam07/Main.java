package greedy.exam07;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
  int v;
  int cost;
  
  public Node(int v, int cost) {
    super();
    this.v = v;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
}


public class Main {
  static boolean[] visited;
  static ArrayList<ArrayList<Node>> graph;

  public int solution( int v) {
    int answer = 0;
    PriorityQueue<Node> pQ = new PriorityQueue<>();
    visited[1] = true;
    for (Node node : graph.get(1)) {
        pQ.offer(node);
    }
    int cnt = 1;
    while (!pQ.isEmpty()) {
      Node node = pQ.poll();
      if (visited[node.v]) continue;
      
      answer += node.cost;
      visited[node.v] = true;
      
      for (Node tmp : graph.get(node.v)) {
        if (!visited[tmp.v]) {
          pQ.offer(tmp);
        }
      }
      
      if (++cnt == v) break;
//      System.out.println(node.v + " " + node.cost);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int v = stdIn.nextInt();
    int e = stdIn.nextInt();
    visited = new boolean[v + 1];
    graph = new ArrayList<ArrayList<Node>>();
    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<Node>());
    }
    for (int i = 0; i < e; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      int c = stdIn.nextInt();
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }
    
    System.out.println(T.solution(v));
  }
}
