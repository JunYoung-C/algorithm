package stackandqueue.ex08;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
  int index;
  int risk;

  public Person(int index, int risk) {
    super();
    this.index = index;
    this.risk = risk;
  }

}


public class Main {

  public int solution(int n, int m, int[] risks) {
    int answer = 1;
    Queue<Person> que = new LinkedList<Person>();
    int riskIdx = risks.length - 1;
    
    for (int i = 0; i < n; i++) {
      que.offer(new Person(i , risks[i]));
    }
    Arrays.sort(risks);
    int max = risks[riskIdx--];

    while (!que.isEmpty()) {
      Person now = que.poll();
      
      if (now.risk == max) {
//        System.out.println(max + " " + answer + " " + now.index);
        if (now.index == m) {
          break;
        }
        max = risks[riskIdx--];
        answer++;
      } else {
        que.offer(now);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[] risks = new int[n];
    for (int i = 0; i < n; i++) {
      risks[i] = stdIn.nextInt();
    }

    System.out.println(T.solution(n, m, risks));
  }
}
