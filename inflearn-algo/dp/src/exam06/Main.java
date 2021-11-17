package exam06;

import java.util.Scanner;

class Problem {
  int point;
  int time;

  public Problem(int point, int time) {
    super();
    this.point = point;
    this.time = time;
  }
}


public class Main {

  public int solution(Problem[] problems, int n, int m) {
    int[] ch = new int[m+1];
    for (Problem problem : problems) {
      for (int i = m; i >= problem.time; i--) {
        ch[i] = Math.max(ch[i], ch[i-problem.time] + problem.point);
      }
    }
    return ch[m];
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    Problem[] problems = new Problem[n];
    for (int i = 0; i < n; i++) {
      int p = stdIn.nextInt();
      int t = stdIn.nextInt();
      problems[i] = new Problem(p, t);
    }
    System.out.println(T.solution(problems, n, m));
  }
}
