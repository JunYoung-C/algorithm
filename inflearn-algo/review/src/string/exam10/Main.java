package string.exam10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public int[] solution(String str, char c) {
    int len = str.length();
    int[] answer = new int[len];
    ArrayList<Integer> indexArr = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == c) {
        indexArr.add(i);
      }
    }

    for (int i = 0; i < len; i++) {
      int min = Integer.MAX_VALUE;
      for (int index : indexArr) {
        min = Integer.min(min, Math.abs(index-i));
      }
      answer[i] = min;
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    char c = stdIn.next().charAt(0);
    for (int i : T.solution(str, c)) {
      System.out.print(i + " ");
    }
  }
}
