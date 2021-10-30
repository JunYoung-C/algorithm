package test;

import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    int a = arr.remove(1);
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.print(a);
    System.out.println(arr.contains(1));
  }
}
