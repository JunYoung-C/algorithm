package palindrome;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    // 내가 짠 코드
    // String answer = "YES";
    // str = str.toUpperCase();
    // int lt = 0, rt = str.length()-1;
    //
    // while (lt < rt) {
    // if (!Character.isAlphabetic(str.charAt(lt))) {
    // lt++;
    // }else if(!Character.isAlphabetic(str.charAt(rt))) {
    // rt--;
    // } else {
    // if (str.charAt(lt) != str.charAt(rt)) {
    // return "NO";
    // }
    // lt++;
    // rt--;
    // }
    // }
    
    // replaceAll로 특수문제 제거 후 진행
    String answer = "NO";
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    String tmp = new StringBuffer(str).reverse().toString();
    if (str.equals(tmp)) answer = "YES";
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.nextLine();
    System.out.println(T.solution(str));
  }
}
