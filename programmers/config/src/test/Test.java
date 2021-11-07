package test;

import java.io.IOException;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) throws IOException {
    String[] answer = new String[3];
    answer[0] += "hi";
    String s = "HELO";
    for (String str : answer) {
      System.out.println(str);
    }
    s = s.substring(5);
    System.out.println(s);

  }
}
