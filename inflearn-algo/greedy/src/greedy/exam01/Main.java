package greedy.exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person>{
  int height;
  int weight;

  Person(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Person o) {
    return o.height - this.height;
  }
}


public class Main {
  public int solution(int n, ArrayList<Person> arr) {
    // O(n^2)라 틀림
//    int answer = n;
//    for (int i = 0; i < n; i++) {
//      Person me = arr.get(i);
//      for (int j = 0; j < n; j++) {
//        if (i == j) continue;
//        Person p = arr.get(j);
//        
//        if (me.height < p.height && me.weight < p.weight) {
//          answer--;
//          break;
//        }
//      }
//    }
    
    int answer = 0;
    Collections.sort(arr);
    int max = Integer.MIN_VALUE;
    for (Person p : arr) {
      if (p.weight > max) {
        max = p.weight;
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
      int h = stdIn.nextInt();
      int w = stdIn.nextInt();
      arr.add(new Person(h, w));
    }
    System.out.println(T.solution(n, arr));
  }
}
