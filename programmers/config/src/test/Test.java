package test;

import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    char[] arr1= Integer.toBinaryString(15).toCharArray();
    char[] arr2= Integer.toBinaryString(23).toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    String str1 = String.valueOf(arr1);
    String str2 = String.valueOf(arr2);

    for (char c : arr1) {
      System.out.print(c + " " );
    }
    System.out.println(str1);
    for (char c : arr2) {
      System.out.print(c + " " );
    }

  }
}
