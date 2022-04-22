package easy;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int cnt = 1;
    int sum = n / 10 + n % 10;
    int newNum = n % 10 * 10 + sum % 10;
    while (n != newNum) {
      sum = newNum / 10 + newNum % 10;
      newNum = newNum % 10 * 10 + sum % 10;
      cnt++;
    }
    System.out.print(cnt);

  }
}
