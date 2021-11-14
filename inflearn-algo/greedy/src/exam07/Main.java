package exam07;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
  int vex;
  int cost;

  public Edge(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }

}


public class Main {
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Edge>());
    }
    int[] ch = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      int c = stdIn.nextInt();
      graph.get(a).add(new Edge(b, c));
      graph.get(b).add(new Edge(a, c));
    }
    int answer = 0;
    PriorityQueue<Edge> pQ = new PriorityQueue<>();
    pQ.offer(new Edge(1, 0));

    while (!pQ.isEmpty()) {
      Edge tmp = pQ.poll();
      int ev = tmp.vex;
      if (ch[ev] == 0) {
        ch[ev] = 1;
        answer += tmp.cost;
        for (Edge ob : graph.get(ev)) {
          if (ch[ob.vex] == 0)
            pQ.offer(new Edge(ob.vex, ob.cost));
        }
      }
    }
    System.out.println(answer);
  }
}
