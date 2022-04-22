package findstring;

import java.util.Scanner;

public class Main {
  public int solution(String str, char t) {
    int answer = 0;
    str = str.toUpperCase();
    t = Character.toUpperCase(t);

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == t) {
        answer++;
      }
    }
//    향상된 for문
//    for (char c : str.toCharArray()) {
//      if (c == t)
//        answer++;
//    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    char c = stdIn.next().charAt(0);
    System.out.print(T.solution(str, c));
  }
}
