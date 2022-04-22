package wordinstring;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    // 내가 짠 코드
    String longestStr = "";
    int max = 0; // Integer.MIN_VALUE가 더 적합함
    
    String[] strArray = str.split(" ");
    for (String s:strArray) {
      if (s.length() > max) {
        max = s.length();
        longestStr = s;
      }
    }
    
    // indexOf와 substring을 사용한 풀이
//    int max = Integer.MIN_VALUE, pos;
//    while ((pos = str.indexOf(" ")) != -1) {
//      String tmp = str.substring(0, pos);
//      int len = tmp.length();
//      if (max < len) {
//        max = len;
//        longestStr = tmp;
//      }
//      str = str.substring(pos+1);
//    }
//    
//    if (str.length() > max) {
//      longestStr = str;
//    }
    return longestStr;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.nextLine();
    System.out.println(T.solution(str));
    
  }

}
