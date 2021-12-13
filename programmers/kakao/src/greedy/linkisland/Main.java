package greedy.linkisland;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
  static int[] unf;

  int Find(int a) {
    if (unf[a] == a)
      return a;
    else
      return unf[a] = Find(unf[a]);
  }

  void Union(int a, int b) {
    int fa = Find(a);
    int fb = Find(b);
    if (fa != fb) {
      unf[fa] = fb;
    }
  }

  public int solution(int n, int[][] costs) {
    int answer = 0;
    int len = costs.length;
    unf = new int[100];
    for (int i = 0; i < 100; i++) {
      unf[i] = i;
    }

    Arrays.sort(costs, new Comparator<int[]>() {

      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2] - o2[2];
      }
    });

    for (int i = 0; i < len; i++) {
      int a = costs[i][0];
      int b = costs[i][1];
      int c = costs[i][2];
      int fa = Find(a);
      int fb = Find(b);
      if (fa != fb) {
        answer += c;
        Union(fa, fb);
      }
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    int n = 4;
    int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
    System.out.println(T.solution(n, costs));
  }
}

