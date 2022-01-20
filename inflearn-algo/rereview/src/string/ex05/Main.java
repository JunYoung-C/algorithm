package string.ex05;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    String answer = "";
    char[] charArr = str.toCharArray();
    int len = charArr.length;
    int lt = 0, rt = len - 1;
    
    while (lt <= rt) {
      while (!Character.isAlphabetic(charArr[lt])) {
        lt++;
      }
      while (!Character.isAlphabetic(charArr[rt])) {
        rt--;
      }
      if (lt > rt) {
        break;
      }
      
      char tmp = charArr[lt];
      charArr[lt] = charArr[rt];
      charArr[rt] = tmp;
      lt++;
      rt--;
    }
    
    answer = String.valueOf(charArr);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.next();
    
    System.out.println(T.solution(str));
  }
}
