package exam01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  int[] dist = {1, -1, 5};
  int[] chk;
  Queue<Integer> que = new LinkedList<>();
  public int bfs(int s, int e) {
    chk = new int[10001];
    que.offer(s);
    chk[s] = 1;
    int L = 0;
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        int x = que.poll();
        for (int j = 0; j < 3; j++) {
          int nx = x + dist[j];
          if (nx == e) return L + 1;
          if (nx >= 1 && nx <= 10000 && chk[nx] == 0) {
            que.offer(nx);
            chk[nx] = 1;
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
    System.out.println(T.bfs(s, e));
  }
}
