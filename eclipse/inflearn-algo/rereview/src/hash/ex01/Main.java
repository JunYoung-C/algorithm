package hash.ex01;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public char solution(int n, String str) {
    char answer = 'A';
    int max = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (char c : str.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char key : map.keySet()) {
      if (max < map.get(key)) {
        max = map.get(key);
        answer = key;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    String str = stdIn.next();
    System.out.println(T.solution(n, str));
  }
}
