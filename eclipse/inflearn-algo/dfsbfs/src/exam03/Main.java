package exam03;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
  int point;
  int time;
  Node(int point, int time) {
    this.point = point;
    this.time = time;
  }
}

public class Main {
  static int answer = Integer.MIN_VALUE;
  static int n = 0, m = 0;
  static ArrayList<Node> arr;
  public void dfs(int L, int pSum, int tSum) {
    if (tSum > m) return;
    if (L == n) {
      answer = Integer.max(answer, pSum);
    } else {
      Node node = arr.get(L);
      dfs(L + 1, pSum + node.point, tSum + node.time);
      dfs(L + 1, pSum, tSum);
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();
    arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int point = stdIn.nextInt();
      int time = stdIn.nextInt();
      arr.add(new Node(point, time));
    }
    T.dfs(0, 0, 0);
    System.out.print(answer);
  }
}
