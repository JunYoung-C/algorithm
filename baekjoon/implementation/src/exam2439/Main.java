package exam2439;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = n-i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
