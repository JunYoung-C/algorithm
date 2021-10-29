package stack.exam08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
  int risk;
  int order;
  Person(int risk, int order) {
    this.risk = risk;
    this.order = order;
  }
}

public class Main {
  public int solution(int n, int m, int[] arr) {
    int answer = 1;
    Queue<Person> que = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      que.offer(new Person(arr[i], i));
    }
    
    while (!que.isEmpty()) {
      Person person = que.poll();
      
      boolean isFirst = true;
      for (Person p : que) {
        if (person.risk < p.risk) {
          isFirst = false;
          break;
        }
      }
      if (isFirst) {
        if (person.order == m) {
          break;
        }
        answer++;
      } else {
        que.offer(person);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, m, arr));
  }
}
