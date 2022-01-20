package string.ex08;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    String answer = "YES";
    char[] charArr = str.toCharArray();
    int lt = 0, rt = charArr.length - 1;
    
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
      if (Character.toUpperCase(charArr[lt++])!= Character.toUpperCase(charArr[rt--])) {
        return "NO";
      }
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    String str = stdIn.nextLine();
    System.out.println(T.solution(str));
  }
}
