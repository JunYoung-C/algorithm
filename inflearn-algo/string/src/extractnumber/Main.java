package extractnumber;

import java.util.Scanner;

public class Main {
  public int solution(String str) {
     int answer = 0;
    // 내가 짠 코드
    // answer = Integer.parseInt(str.replaceAll("[^0-9]", ""));
    
//    for (char x: str.toCharArray()) {
//      if (x >= 48 && x <= 57) answer = answer*10 + (x-48);
//    }
    
     String tmp = "";
     for (char x: str.toCharArray()) {
       if (Character.isDigit(x)) tmp +=x;
     }
     answer = Integer.parseInt(tmp);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.nextLine();
    System.out.println(T.solution(str));
  }
}
