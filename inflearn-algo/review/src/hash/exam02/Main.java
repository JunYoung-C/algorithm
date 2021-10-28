package hash.exam02;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public String solution(String str1, String str2) {
    String answer = "NO";
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (char key : str1.toCharArray()) {
      map1.put(key, map1.getOrDefault(key, 0) + 1);
    }
    
    for (char key : str2.toCharArray()) {
      map2.put(key, map2.getOrDefault(key, 0) + 1);
    }
    
    if (map1.equals(map2)) {
      answer = "YES";
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str1 = stdIn.next();
    String str2 = stdIn.next();
    System.out.println(T.solution(str1, str2));
  }
}
