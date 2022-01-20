package string.ex12;

import java.util.Scanner;

public class Main {

  public String solution(int n, String str) {
    String answer = "";
    char[] charArr = str.toCharArray();
    int len = str.length();
    
    // 문자를 이진수로 변환
    for (int i = 0; i < len; i++) {
      if (charArr[i] == '#') {
        charArr[i] = '1';
      } else {
        charArr[i] = '0';
      }
    }
    String numStr = String.valueOf(charArr);
    
    // 이진수를 단어로 변환
    for (int i = 0; i < len; i += 7) {
      char c = (char) Integer.parseInt(numStr.substring(i, i + 7), 2);
      
      answer += c;
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    String str = stdIn.next();
    System.out.println(T.solution(n, str));
  }
}
