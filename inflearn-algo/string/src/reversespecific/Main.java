package reversespecific;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    // 내가 짠 코드
    // String answer = "";
    // char[] tmp = str.toCharArray();
    // int lt = 0, rt = str.length() - 1;
    // while (lt < rt) {
    // while (!(tmp[lt] >= (int) 'a' && tmp[lt] <= (int) 'z'
    // || tmp[lt] >= (int) 'A' && tmp[lt] <= (int) 'Z')) {
    // lt++;
    // }
    // while (!(tmp[rt] >= (int) 'a' && tmp[rt] <= (int) 'z'
    // || tmp[rt] >= (int) 'A' && tmp[rt] <= (int) 'Z')) {
    // rt--;
    // }
    // char t = tmp[lt];
    // tmp[lt] = tmp[rt];
    // tmp[rt] = t;
    // lt++;
    // rt--;
    // }
    // answer = String.valueOf(tmp);

    String answer;
    char[] s = str.toCharArray();
    int lt = 0, rt = str.length() - 1;
    while (lt < rt) {
      if (!Character.isAlphabetic(s[lt]))
        lt++;
      else if (!Character.isAlphabetic(s[rt]))
        rt--;
      else {
        char t = s[lt];
        s[lt] = s[rt];
        s[rt] = t;
        lt++;
        rt--;
      }
    }
    answer = String.valueOf(s);
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
