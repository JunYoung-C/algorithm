package test;

import java.io.IOException;
import java.util.Scanner;

public class Test {
  boolean isPrime(int num) {
    if (num <= 1) return false; 
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        System.out.print(i);
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    Test T = new Test();
    Scanner stdIn = new Scanner(System.in);
    System.out.print(T.isPrime(stdIn.nextInt()));
  }
}
