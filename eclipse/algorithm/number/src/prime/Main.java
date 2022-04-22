package prime;

import java.util.Scanner;

// 해당 숫자가 소수인지 판별

public class Main {
  boolean solution(int num) {
    if (num < 2)
      return false;
    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}
