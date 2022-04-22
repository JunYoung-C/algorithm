package ex1789;

import java.util.Scanner;

public class Main {
  public long solution(long n) {
    long answer = 1;
    while (true) {
      if (answer * answer + answer > 2*n) {
        answer -= 1;
        break;
      } else {
        answer++;
      }
    }
    
    return answer;
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    long n = stdIn.nextLong();
    System.out.println(T.solution(n));
  }
}
