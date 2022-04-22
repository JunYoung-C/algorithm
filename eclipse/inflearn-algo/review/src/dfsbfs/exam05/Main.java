package dfsbfs.exam05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public int bfs(int n, int[] coins,int money) {
    Queue<Integer> que = new LinkedList<>();
    que.offer(0);
    int L = 0;
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        int currentMoney = que.poll();
        for (int coin : coins) {
          int nextMoney = currentMoney + coin;
          if (nextMoney == money) {
            return L + 1;
          }
          if (nextMoney < money) {
            que.offer(nextMoney);
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
    int n = stdIn.nextInt();
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) {
      coins[i] = stdIn.nextInt();
    }
    int money = stdIn.nextInt();
    System.out.println(T.bfs(n, coins, money));
  }
}
