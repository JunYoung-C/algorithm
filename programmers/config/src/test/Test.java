package test;

import java.util.HashMap;

public class Test {
  public static void main(String[] args) {
    int[] lower = new int[26];
    int[] upper = new int[26];
    for (int i = 0; i < 26; i++) {
      lower[i] = (char) (i + 'a');
      upper[i] = (char) (i + 'A');
    }
    

    for (int i = 0; i < 26; i++) {
      System.out.println((char)lower[i] + " " + (char)upper[i]);
    }
  }
}
