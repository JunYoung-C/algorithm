package exam14;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


public class Main {
  static int n, m; // m개의 피자집
  static ArrayList<Point> homes = new ArrayList<>(), pizzas = new ArrayList<>();
  static int[] ch;
  static int minDis = Integer.MAX_VALUE; // 최종 최소거리

  public void dfs(int L, int s) {
    if (L == m) {
      // 해당 피자집 최소거리를 배열에 삽입
      int sum = 0; // 집마다 가장 가까운 피자집과의 거리의합
      for (Point home : homes) {
        int dis = Integer.MAX_VALUE; // 집마다 가장 가까운 피자집과의 거리
        for (int i : ch) {
          Point pizza = pizzas.get(i-1);
          int diff = Math.abs(pizza.x - home.x) + Math.abs(pizza.y - home.y);
          dis = Integer.min(dis, diff);
        }
        sum += dis;
      }
      minDis = Integer.min(minDis, sum);
    } else {
      for (int i = s; i <= pizzas.size(); i++) {
        ch[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    n = stdIn.nextInt();
    m = stdIn.nextInt();

    for (int y = 1; y <= n; y++) {
      for (int x = 1; x <= n; x++) {
        int value = stdIn.nextInt();
        if (value == 1) { // 집
          homes.add(new Point(x, y));
        } else if (value == 2) { // 피자집
          pizzas.add(new Point(x, y));
        }
      }
    }
    ch = new int[m];
    T.dfs(0, 1);
    System.out.println(minDis);
  }
}
