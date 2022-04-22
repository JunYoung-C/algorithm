package greedy.exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Person implements Comparable<Person>{
  int time;
  char state;
  
  public Person(int time, char state) {
    super();
    this.time = time;
    this.state = state;
  }

  @Override
  public int compareTo(Person o) {
    if (this.time == o.time) return this.state - o.state;
    return this.time - o.time;
  }
  
}
public class Main {

  public int solution(int n, ArrayList<Person> arr) {
    int answer = 0;
    int cnt = 0;
    Collections.sort(arr);
    for (int i = 0; i < arr.size(); i++) {
      Person p = arr.get(i);
      if (p.state == 'e') {
        cnt--;
      }
      if (p.state == 's') {
        cnt++;
      }
      answer = Math.max(answer, cnt);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    ArrayList<Person> arr = new ArrayList<>();
    int n = stdIn.nextInt();
    for(int i = 0; i < n; i++) {
      int start = stdIn.nextInt();
      int end = stdIn.nextInt();
      arr.add(new Person(start, 's'));
      arr.add(new Person(end, 'e'));
    }
    System.out.println(T.solution(n, arr));
  }
}
