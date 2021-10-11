package test;

import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    int[] a = {2, 4, 3, 2, 8};
    Arrays.sort(a);
    for (int i: a) {
      System.out.print(i + " ");
    }
  }
}
