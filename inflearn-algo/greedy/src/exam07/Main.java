package exam07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
  int v1;
  int v2;
  int cost;
  public Edge(int v1, int v2, int cost) {
    super();
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }
  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }
  
}
public class Main {
  static int[] unf;
  
  static int Find(int v) {
    if (v == unf[v]) return v;
    else return unf[v] = Find(unf[v]);
  }
  static void Union(int a, int b) {
    int fa = Find(a);
    int fb = Find(b);
    if (fa != fb) unf[fa] = fb;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    unf = new int[n + 1];
    ArrayList<Edge> arr = new ArrayList<>();
    for (int i  =1; i <= n; i++) unf[i] = i;
    for (int i = 0; i < m; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      int c = stdIn.nextInt();
      arr.add(new Edge(a, b, c));
    }
    int answer = 0;
    Collections.sort(arr);
    for (Edge ob : arr) {
      int fv1 = Find(ob.v1);
      int fv2 = Find(ob.v2);
      if (fv1 != fv2) {
        answer += ob.cost;
        Union(ob.v1, ob.v2);
      }
    }
  }
}
