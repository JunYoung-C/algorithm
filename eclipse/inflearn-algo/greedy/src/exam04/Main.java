package exam04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
  int d;
  int m;

  Lecture(int d, int m) {
    this.d = d;
    this.m = m;
  }

  @Override
  public int compareTo(Lecture o) {
    return o.d - this.d;
  }
}


public class Main {
  static int n, max = Integer.MIN_VALUE;

  public int solution(int n, ArrayList<Lecture> arr) {
    int answer = 0;
    Collections.sort(arr);
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    int j = 0;
    for (int i = max; i >= 1; i--) {
      for (; j < n; j++) {
        if (arr.get(j).d < i)
          break;
        pQ.offer(arr.get(j).m);
      }
      if (!pQ.isEmpty())
        answer += pQ.poll();
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Lecture> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = stdIn.nextInt();
      int d = stdIn.nextInt();
      arr.add(new Lecture(d, m));
      if (max < d) max = d;
    }
    System.out.println(T.solution(n, arr));
  }
}
