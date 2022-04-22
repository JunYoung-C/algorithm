package reverseprime;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//  내가 짠 코드
//  public ArrayList<Integer> solution(int n, String[] strArr) {
//    ArrayList<Integer> answer = new ArrayList<>();
//    for (String s: strArr) {
//      StringBuffer sb = new StringBuffer(s);
//      int num = Integer.parseInt(sb.reverse().toString());
//      boolean prime = true;
//      for (int i = 2; i <= Math.sqrt(num); i++) {
//        if (num % i == 0) {
//          prime = false;
//          break;
//        }
//      }
//      if (prime && num != 1) {
//        answer.add(num);
//      }
//    }
//
//    return answer;
//  }
  public boolean isPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i < num; i++) {
      if (num%i == 0) return false;
    }
    return true;
  }
  public ArrayList<Integer> solution(int n, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int tmp = arr[i];
      int res = 0;
      while (tmp > 0) {
        int t = tmp % 10;
        res = res * 10 + t;
        tmp = tmp/10;
      }
      if (isPrime(res)) answer.add(res);
    }
    return answer;
  }
  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] strArr = new int[n];
    for (int i = 0; i < n; i++) {
      strArr[i] = stdIn.nextInt();
    }
    for (int s: T.solution(n, strArr)) {
      System.out.print(s + " ");
    }
  }
}

// 최대 100개니깐 n 3승도 가능
// string[]으로 입력 받기
// string 요소를 뒤집은 후 int형으로 판별 
  //- 향상된 for문, 새로운 ArrayList<String> 필요
// 제곱근을 사용해서 판별 - 소수면 ArrayList<String> 배열에 추가