package bruteforce.ex1436;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0;
    int cnt = 0;
    int num = 666;
    while (cnt < n) {
      if (isContain666(num)) {
        answer = num;
        cnt++;
      }
      num++;
    }
    
    return answer;
  }
  boolean isContain666(int num) {
    String strNum = String.valueOf(num);
    if (strNum.contains("666")) {
      return true;
    } else {
      return false;
    }
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}

