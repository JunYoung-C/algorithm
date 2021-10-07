package calcpoint;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[] ox) {
    int answer = 0;
    int p = 0;
    for (int i:ox) {
      if (i == 1) {
        p++;
        answer += p;
      } else {
        p = 0;
      }
      
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] ox = new int[n];
    for (int i = 0; i < n; i++) {
      ox[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, ox));
  }
}
