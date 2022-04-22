package greedy.exam06;

import java.util.Scanner;

public class Main {
  static int[] unf;
  static int find(int i) {
    if (i == unf[i]) return i;
    return unf[i] = find(unf[i]);
  }

  static void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);
    if (fa != fb) unf[fa] = fb;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    unf = new int[n+1];
    for (int i = 1; i <= n; i++) {
      unf[i] = i;
    }
    for (int i = 0; i < m; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      union(a, b);
    }
    
    int a = stdIn.nextInt();
    int b = stdIn.nextInt();
    int fa = find(a);
    int fb = find(b);
    if (fa == fb) System.out.println("YES");
    else System.out.println("NO");
  }
}
