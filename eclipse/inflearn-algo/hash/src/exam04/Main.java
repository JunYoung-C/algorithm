package exam04;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public int solution(String s, String t) {
    int answer = 0;
    // 내가 짠 코드
//    HashMap<Character, Integer> map = new HashMap<>();
//    for (char c : t.toCharArray()) {
//      map.put(c, map.getOrDefault(c, 0) + 1);
//    }
//
//    int lt = 0, rt;
//    for (rt = 0; rt < t.length() - 1; rt++) {
//      char key = s.charAt(rt);
//      if (map.containsKey(key)) {
//        map.put(key, map.get(key) - 1);
//      }
//    }
//
//    while (rt < s.length()) {
//      char key = s.charAt(rt++);
//      if (map.containsKey(key)) {
//        map.put(key, map.get(key) - 1);
//      }
//      
//      // 모두 0이면 answer++;
//      boolean check = true;
//      for (int value : map.values()) {
//        if (value != 0) {
//          check = false;
//        }
//      }
//      if (check) {
//        answer++;
//      }
//      
//      key = s.charAt(lt++);
//      if (map.containsKey(key)) {
//        map.put(key, map.get(key) + 1);
//      }
//    }

    // equals 이용
    HashMap<Character, Integer> sm = new HashMap<>();
    HashMap<Character, Integer> tm = new HashMap<>();
    for (char x : t.toCharArray()) tm.put(x, tm.getOrDefault(x, 0) + 1);
    
    int L = t.length() - 1;
    for (int i = 0; i < L; i++) {
      sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0) + 1);
    }
      int lt = 0;
      for (int rt = L; rt < s.length(); rt++) {
        sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0) + 1);
        if (sm.equals(tm)) answer++;
        sm.put(s.charAt(lt), sm.get(s.charAt(lt))-1);
        if (sm.get(s.charAt(lt)) == 0) sm.remove(s.charAt(lt));
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
