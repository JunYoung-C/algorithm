package continueint;

import java.util.Scanner;

public class Main {
  public int solution(int n) {
    int answer = 0, lt = 1, sum = 0;
    for (int rt = 1; rt < n; rt++) {
      sum += rt;
      if (sum == n) {
        answer++;
      }
      while (sum > n) {
        sum -= lt++;
        if (sum == n) {
          answer++;
          break;
        }
      }

    }
    
    // for문의 종료지점을 n/2+1에 도달할때까지로 설정해도 된다. 
    // 그 이후의 값은 연속된 두 자연수로 n이 될 수 없다.
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}
