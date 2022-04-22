package array.ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {
    int[] answer = {};
    ArrayList<Integer> primeList = new ArrayList<Integer>();
    
    for (int i = 0; i < n; i++) {
      arr[i] = reversedNum(arr[i]);
    }
    
    for (int i = 0; i < n; i++) {
      if (isPrime(arr[i])) {
        primeList.add(arr[i]);
      }
    }
    
    int len = primeList.size();
    answer = new int[len];
    for (int i = 0; i < len; i++) {
      answer[i] = primeList.get(i);
    }
    return answer;
  }
  
  int reversedNum(int num) {
    StringBuffer sb = new StringBuffer(num);
    
    return Integer.parseInt(sb.reverse().toString());
  }

  boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i < (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    
    return true;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[] arr = new int[n];
    
    for (int i : T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}
