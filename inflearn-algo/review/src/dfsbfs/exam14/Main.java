package dfsbfs.exam14;

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
  static int answer = Integer.MAX_VALUE;
  static ArrayList<Point> pizzas = new ArrayList<>(), homes = new ArrayList<>();
  static Point[] selectedPizzas;
  static int maxPizza, n;

  public void dfs(int L, int s) {
    if (L == maxPizza) {
      int minDistSum = 0;
      for (Point home : homes) {
        int minDist = Integer.MAX_VALUE;
        for (Point pizza : selectedPizzas) {
          int dist = Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y);
          minDist = Integer.min(minDist, dist);
        }
        minDistSum += minDist;
      }
      answer = Integer.min(answer, minDistSum);
    } else {
      for (int i = s; i < pizzas.size(); i++) {
        selectedPizzas[L] = pizzas.get(i);
        dfs(L + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    pizzas = new ArrayList<>();
    homes = new ArrayList<>();
    n = stdIn.nextInt();
    maxPizza = stdIn.nextInt();

    for (int y = 1; y <= n; y++) {
      for (int x = 1; x <= n; x++) {
        int value = stdIn.nextInt();
        if (value == 1) {
          homes.add(new Point(x, y));
        } else if (value == 2) {
          pizzas.add(new Point(x, y));
        }
      }
    }
    selectedPizzas = new Point[maxPizza];
    T.dfs(0, 0);
    System.out.println(answer);
  }
}
