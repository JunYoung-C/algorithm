package ex1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public int solution(String s) {
    if (s.length() == 0) return 0;
    int answer = 0;
    
    int[] ch = new int[2];
    ch[s.charAt(0)-'0']++;
    
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i-1)) {
        ch[s.charAt(i)-'0']++;
      }
    }

    answer = Math.min(ch[0], ch[1]);
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    
    System.out.println(T.solution(s));
  }
}

