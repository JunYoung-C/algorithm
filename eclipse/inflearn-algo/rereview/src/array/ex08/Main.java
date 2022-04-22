package array.ex08;

import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    
    for (int i = 0; i < n; i++) {
      int rank = 1;
      
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (arr[i] < arr[j]) {
          rank++;
        }
      }
      
      answer[i] = rank;
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    for (int i : T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}
