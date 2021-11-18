package greedy.exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Conf implements Comparable<Conf> {
  int start;
  int end;

  public Conf(int start, int end) {
    super();
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(Conf o) {
    if (this.end == o.end)
      return this.start - o.start;
    return this.end - o.end;
  }

}


public class Main {

  public int solution(int n, ArrayList<Conf> confs) {
    int answer = 0;
    int endTime= 0;
    Collections.sort(confs);
    for (int i = 0; i < n; i++) {
      Conf conf = confs.get(i);
      if (endTime <= conf.start) {
        endTime = conf.end;
        answer++;
//        System.out.println(conf.start + " " + conf.end);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Conf> confs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int s = stdIn.nextInt();
      int e = stdIn.nextInt();
      confs.add(new Conf(s, e));
    }
    System.out.println(T.solution(n, confs));
  }
}
