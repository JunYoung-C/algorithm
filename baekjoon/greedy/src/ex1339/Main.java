package ex1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public int solution(int n, String[] strs) {
    int answer = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (String str : strs) {
      int len = str.length();
      for (int i = 0; i < len; i++) {
        int num = len - i - 1;
        map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + (int) Math.pow(10, num));
      }
    }

    char maxNum = '9';
    while (!map.isEmpty()) {
      char maxKey = ' ';
      int maxValue = Integer.MIN_VALUE;
      for (char k : map.keySet()) {
        if (map.get(k) > maxValue) {
          maxKey = k;
          maxValue = map.get(k);
        }
      }
      map.remove(maxKey);

      if (maxKey == ' ')
        continue;
      
      for (int i = 0; i < n; i++) {
        strs[i] = strs[i].replace(maxKey, maxNum);
      }
      maxNum--;
    }
    
    for (String s : strs) {
      answer += Integer.parseInt(s);
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] strs = new String[n];
    for (int i = 0; i < n; i++) {
      strs[i] = br.readLine();
    }

    System.out.println(T.solution(n, strs));
  }
}
