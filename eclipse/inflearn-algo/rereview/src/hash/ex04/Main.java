package hash.ex04;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public int solution(String str1, String str2) {
    int answer = 0;
    HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    int lt = 0, rt = 0;
    
    for (; rt < str2.length(); rt++) {
      map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);
      map2.put(str2.charAt(rt), map2.getOrDefault(str2.charAt(rt), 0) + 1);
    }
    if (map1.equals(map2)) {
      answer++;
    }

    for (;rt < str1.length(); rt++) {
      map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);
      map1.put(str1.charAt(lt), map1.get(str1.charAt(lt)) - 1);

      if (map1.get(str1.charAt(lt)) == 0) {
        map1.remove(str1.charAt(lt));
      }
      
      lt++;
      
      if (map1.equals(map2)) {
        answer++;
      }
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
