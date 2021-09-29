package reverseword;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  // 내가 짠 코드
  // public void solution(int num, String[] strArr) {
  // String[] answer = new String[num];
  // int arrLen = strArr.length;
  // for (int i = 0; i < arrLen; i++) {
  // String word = strArr[i];
  // String reversedWord = "";
  //
  // int len = word.length();
  // for (int j = len - 1; j >= 0; j--) {
  // reversedWord += word.charAt(j);
  // }
  // answer[i] = reversedWord;
  // }
  //
  // for (String s: answer) {
  // System.out.println(s);
  // }
  // }
  //
  // public static void main(String[] args) {
  // Main T = new Main();
  // Scanner stdIn = new Scanner(System.in);
  // int num = stdIn.nextInt();
  // String[] strArr = new String[num];
  // for (int i = 0; strArr.length > i; i++) {
  // strArr[i] = stdIn.next();
  // }
  // T.solution(num, strArr);
  // }

  public ArrayList<String> solution(int n, String[] str) {
    ArrayList<String> answer = new ArrayList<>();
    // StringBuffer 사용하는 방식
    // for (String x: str) {
    // String tmp = new StringBuffer(x).reverse().toString();
    // answer.add(tmp);
    // }

    // 문자의 양 끝을 교환하는 방식
    for (String x: str) {
      char[] s = x.toCharArray();
      int lt = 0, rt = x.length()-1;
      while (lt < rt) {
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(s);
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int num = stdIn.nextInt();
    String[] strArr = new String[num];
    for (int i = 0; num > i; i++) {
      strArr[i] = stdIn.next();
    }

    for (String x : T.solution(num, strArr)) {
      System.out.println(x);
    }
  }
}
