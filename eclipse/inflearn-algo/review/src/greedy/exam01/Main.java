package greedy.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {
  int h;
  int w;

  public Person(int h, int w) {
    this.h = h;
    this.w = w;
  }

  @Override
  public int compareTo(Person o) {
    if (this.h == o.h)
      return o.w - this.w;
    return o.h - this.h;
  }

}


public class Main {

  public int solution(int n, ArrayList<Person> arr) {
    int answer = 0;
    
    Collections.sort(arr);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      Person person = arr.get(i);
      if (person.w > max) {
        max = person.w;
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    ArrayList<Person> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int k = stdIn.nextInt();
      int w = stdIn.nextInt();
      arr.add(new Person(k, w));
    }
    System.out.println(T.solution(n, arr));
  }
}
