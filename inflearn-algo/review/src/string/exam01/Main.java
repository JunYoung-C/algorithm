package string.exam01;

import java.util.Scanner;

public class Main {
  public int solution(String str, char c) {
    int answer = 0;
    str.toUpperCase();
    
    for (char i : str.toLowerCase().toCharArray()) {
      if (i == Character.toLowerCase(c)) answer++;
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    char c = stdIn.next().charAt(0);
    System.out.println(T.solution(str, c));
  }
}
