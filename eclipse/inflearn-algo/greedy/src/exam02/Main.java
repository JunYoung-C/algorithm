package exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Conf implements Comparable<Conf> {
  int start;
  int end;

  Conf(int start, int end) {
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

  public int solution(int n, ArrayList<Conf> arr) {
    int answer = 0;
    Collections.sort(arr);
    int endTime = Integer.MIN_VALUE;
    for (int crnt = 0; crnt < n; crnt++) {
      Conf crntConf = arr.get(crnt);
      if (endTime <= crntConf.start) {
        answer++;
        endTime = crntConf.end;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Conf> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int s = stdIn.nextInt();
      int e = stdIn.nextInt();
      arr.add(new Conf(s, e));
    }
    System.out.println(T.solution(n, arr));
  }
}
