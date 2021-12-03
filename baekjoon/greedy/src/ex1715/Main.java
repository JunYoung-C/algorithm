package ex1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Main {
  public Long solution(int n, Long[] arr) {
    Long answer = 0l;
    PriorityQueue<Long> pQ = new PriorityQueue<>();
    for (Long i : arr) {
      pQ.add(i);
    }
    while (pQ.size() > 1) {
      Long a = pQ.poll();
      Long b = pQ.poll();
//      System.out.println(a + " " + b);
      pQ.add(a + b);
      answer += a + b;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Long[] arr = new Long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }
    System.out.println(T.solution(n, arr));

  }
}

