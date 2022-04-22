package hash.exam01;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public char solution(int n, String str) {
    char answer = ' ';
    HashMap<Character, Integer> map = new HashMap<>();
    for (char key : str.toCharArray()) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    int max = Integer.MIN_VALUE;
    
    for (char key : map.keySet()) {
      int value = map.getOrDefault(key, 0);
      if (max < value) {
        max = value;
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
