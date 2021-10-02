package startequalend;

import java.util.Scanner;

public class Main {

  public String solution(String str) {
    // 내가 짠 코드
//      String answer; 
//      str = str.toUpperCase();
//      int lt = 0, rt = str.length()-1;
//      while (lt < rt) {
//        if (str.charAt(lt) != str.charAt(rt)) break;
//        lt++;
//        rt--;
//      }
//      
//      if (lt >= str.length()/2) {
//        answer = "YES";
//      } else {
//        answer = "NO";
//      }
    
    // for문 사용
//    String answer = "YES";
//    str = str.toUpperCase();
//    int len = str.length();
//    for (int i = 0; i < len/2; i++) {
//      if (str.charAt(i) != str.charAt(len-i-1)) return "NO";
//    }
    
    String answer="NO";
    String tmp = new StringBuilder(str).reverse().toString();
    
    if (str.equalsIgnoreCase(tmp)) answer = "YES";
      return answer;
    }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
