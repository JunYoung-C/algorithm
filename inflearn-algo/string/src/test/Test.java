package test;

import java.util.ArrayList;

public class Test {

  public static void main(String[] args) {
    String str = "!!#@f#f#g$h";
    char[] tmp = str.toCharArray();
    int lt = 0, rt = str.length() - 1;
    while (!(tmp[lt] >= (int)'a' && tmp[lt] <= (int)'z' || tmp[lt] >= (int)'A' && tmp[lt] <= (int)'Z')) {
      lt++;
    }
    System.out.println(lt);
  }
}
