package exam2742;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    for (int i = n; i >= 1; i--) {
      System.out.println(i);
    }
  }
}
