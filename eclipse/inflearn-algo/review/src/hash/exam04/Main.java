package hash.exam04;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public int solution(String s, String t) {
    int answer = 0;
    HashMap<Character, Integer> sMap = new HashMap<>();
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    }
    
    int lt = 0;
    int rt = 0;
    for (; rt < t.length()-1; rt++) {
      char key = s.charAt(rt);
      sMap.put(key , sMap.getOrDefault(key, 0) + 1);
    }
    
    for (; rt < s.length(); rt++) {
      char key = s.charAt(rt);
      char prevKey = s.charAt(lt);
      sMap.put(key , sMap.getOrDefault(key, 0) + 1);
      
      if (tMap.equals(sMap)) {
        answer++;
      }
      
      if (sMap.get(prevKey) == 1) {
        sMap.remove(prevKey);
      } else {
        sMap.put(prevKey , sMap.get(prevKey) - 1);
      }
      lt++;
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String s = stdIn.next();
    String t = stdIn.next();
    System.out.println(T.solution(s, t));
  }
}
