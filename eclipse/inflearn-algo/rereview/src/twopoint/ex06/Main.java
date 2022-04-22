package twopoint.ex06;

import java.util.Scanner;

public class Main {

  public int solution(int n, int k, int[] arr) {
    int answer = 0;
    int cnt = 0;
    int lt = 0, rt = 1;
    int sum = 0;
    for (; rt <= n; rt++) {
      if (arr[rt] == 0) {
        if (cnt < k) {
          cnt++;
        } else if (cnt == k) {

          while (lt <= rt ) {
            lt++;
            if (arr[lt] == 0) {
              break;
            }
          }
        }
      } 
      
//      System.out.println(lt + " " + rt + " " + (rt - lt));
      answer = Math.max(answer, rt - lt);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    
    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
      arr[i] = stdIn.nextInt();
      
    }
    
    System.out.println(T.solution(n, k, arr));
  }
}
