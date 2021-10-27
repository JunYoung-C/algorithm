package string.exam08;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "YES";
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    char[] arr = str.toCharArray();
    int lt = 0;
    int rt = str.length()-1;
    while (lt < rt) {
      if (arr[lt] != arr[rt]) {
        return "NO";
      }
      lt++;
      rt--;
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
