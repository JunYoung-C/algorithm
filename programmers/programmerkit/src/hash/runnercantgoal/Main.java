package hash.runnercantgoal;

import java.util.HashMap;
import java.util.Scanner;

class Solution {
  public String solution(String[] participant, String[] completion) {
      String answer = "";
      HashMap<String, Integer> map = new HashMap<>();
      
      for (String p : participant) {
        map.put(p, map.getOrDefault(p, 0) + 1);
      }
      for (String c : completion) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          map.remove(c);
        }
      }
      
      for (String k : map.keySet()) {
        answer = k;
      }
      return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println(T.solution());
  }
}

