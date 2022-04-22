package string.exam05;

import java.util.Scanner;

public class Main {
  public String solution(String str) {
    String answer = "";
    char[] arr = str.toCharArray();
    int lt = 0;
    int rt = str.length()-1;
    while (lt < rt) {
      while (!Character.isAlphabetic(arr[lt])) {
        lt++;
      }
      while (!Character.isAlphabetic(arr[rt])) {
        rt--;
      }
      char tmp = arr[lt];
      arr[lt] = arr[rt];
      arr[rt] = tmp;
      lt++;
      rt--;
    }
    String.valueOf(arr);
    answer = String.valueOf(arr);
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    System.out.println(T.solution(str));
  }
}
