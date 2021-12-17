package hash.disguise;

import java.util.HashMap;
import java.util.Scanner;

class Solution {
  public int solution(String[][] clothes) {
      int answer = 1;
      HashMap<String, Integer> map = new HashMap<>();
      
      for (String[] cl : clothes) {
        map.put(cl[1], map.getOrDefault(cl[1], 0) + 1);
      }
      
      for (int v : map.values()) {
        answer *= (v + 1);
      }
      return answer - 1;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println(T.solution());
  }
}