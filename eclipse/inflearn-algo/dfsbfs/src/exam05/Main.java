package exam05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public int bfs(int n, int m, int[] coins) {
    Queue<Integer> que = new LinkedList<>();
    int[] ch = new int[m + 1];
    int L = 1;
    for (int coin : coins) {
      que.offer(coin);
    }
    
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        int prev = que.poll();
        for (int coin : coins) {
          int current = prev + coin;
          if (current == m) return L + 1;
          que.offer(current);
        }
      }
      L++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = stdIn.nextInt();
    }
    int m = stdIn.nextInt();
    System.out.println(T.bfs(n, m, coins));
  }
}
