package exam02;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public String solution(String str1, String str2) {
    String answer = "YES";
    // 내가 짠 코드
//    HashMap<Character, Integer> firstMap = new HashMap<>();
//    HashMap<Character, Integer> secondMap = new HashMap<>();
//    
//    for (char c : str1.toCharArray()) {
//      firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);
//    }
//    
//    for (char c : str2.toCharArray()) {
//      secondMap.put(c, secondMap.getOrDefault(c, 0) + 1);
//    }
//    
//    for (char key1 : firstMap.keySet()) {
//      if (!secondMap.keySet().contains(key1)) {
//        return "NO";
//      }
//      
//      if (firstMap.get(key1) != secondMap.get(key1)) {
//        return "NO";
//      }
//    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    for (char x : str1.toCharArray()) {
      map.put(x,  map.getOrDefault(x, 0) + 1);
    }
    for (char x : str2.toCharArray()) {
      if (!map.containsKey(x)||map.get(x) == 0) return "NO";
      map.put(x, map.get(x) - 1);
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
