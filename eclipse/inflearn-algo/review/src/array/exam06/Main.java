package array.exam06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    for (int num : arr) {
      int reversedNum = 0;
      while (num / 10 != 0) {
        reversedNum = reversedNum *10 + num%10;
        num = num/10;
      }
      reversedNum = reversedNum *10 + num%10;

      boolean flag = true;
      for (int i = 2; i < reversedNum; i++) {
        if (reversedNum % i == 0) {
          flag = false;
          break;
        }
      }
      if (flag && reversedNum != 1) {
        answer.add(reversedNum);
      }
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
    for (int i:T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}
