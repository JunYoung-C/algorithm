package recurtreegraph.exam08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  int[] dx = {1, -1, 5};
  static int[] ch;

  public int bfs(int s, int e) {
    int L = 0;
    Queue<Integer> que = new LinkedList<>();
    que.offer(s);
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        int x = que.poll();
        for (int j = 0; j < 3; j++) {
          int nx = x + dx[j];
          if (nx == e)
            return L + 1;
          if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
            ch[nx] = 1;
            que.offer(nx);
          } 
        }
      }
      L++;
    }

    return -1;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int s = stdIn.nextInt();
    int e = stdIn.nextInt();
    ch = new int[10001];
    System.out.println(T.bfs(s, e));
  }
}
