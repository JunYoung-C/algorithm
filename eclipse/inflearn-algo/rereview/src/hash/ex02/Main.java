package hash.ex02;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public String solution(String str1, String str2) {
    HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    
    for (char c : str1.toCharArray()) {
      map1.put(c, map1.getOrDefault(c, 0) + 1);
    }
    for (char c : str2.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0) + 1);
    }
    
    if (map1.equals(map2)) {
      return "YES";
    } else {
      return "NO";
    }
    
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str1 = stdIn.next();
    String str2 = stdIn.next();
    
    System.out.println(T.solution(str1, str2));
  }
}
