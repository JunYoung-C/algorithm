package unionfind;

import java.util.Scanner;

// 입력
// 9 7
// 1 2
// 2 3
// 3 4
// 1 5
// 6 7
// 7 8
// 8 9
// 3 8
//
// 출력
// NO

public class Main {
  static int[] unf;
  
  public static int Find(int v) {
    if (v == unf[v])
      return v;
    else
      return unf[v] = Find(unf[v]);
  }
  
  public static void Union(int a, int b) {
    int fa = Find(a);
    int fb = Find(b);
    if (fa != fb)
      unf[fa] = fb;
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    unf = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      unf[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      int a = stdIn.nextInt();
      int b = stdIn.nextInt();
      Union(a, b);
    }
    
    int a = stdIn.nextInt();
    int b = stdIn.nextInt();
    int fa = Find(a);
    int fb = Find(b);
    if (fa == fb)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
