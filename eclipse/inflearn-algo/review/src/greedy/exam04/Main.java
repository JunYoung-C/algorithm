package greedy.exam04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
  int d;
  int m;

  public Lecture(int d, int m) {
    super();
    this.d = d;
    this.m = m;
  }

  @Override
  public int compareTo(Lecture o) {
    return o.d - this.d;
  }

}


public class Main {

  public int solution(int n, ArrayList<Lecture> lectures) {
    int answer = 0;
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    Collections.sort(lectures);
    int maxD = lectures.get(0).d;
    int j = 0;
    for (int i = maxD; i >0; i--) {
      for (; j < n; j++) {
        if (i > lectures.get(j).d) break;
        pQ.offer(lectures.get(j).m);
      }
      
      if (!pQ.isEmpty()) answer += pQ.poll();
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Lecture> lectures = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = stdIn.nextInt();
      int d = stdIn.nextInt();
      lectures.add(new Lecture(d, m));
    }
    System.out.println(T.solution(n, lectures));
  }
}
