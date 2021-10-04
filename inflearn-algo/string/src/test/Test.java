package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    String str = stdIn.next();
    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    System.out.println(a.toArray()[0]);
  }
}
