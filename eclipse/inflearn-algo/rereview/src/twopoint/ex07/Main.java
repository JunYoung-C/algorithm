package twopoint.ex07;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

  public int solution(int n, int k, int[] arr) {
    int answer = -1;
    TreeSet<Integer> numSet = new TreeSet<Integer>(Collections.reverseOrder());
    

    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int h = j + 1; h < n; h++) {
          int sum = arr[i] + arr[j] + arr[h];
          numSet.add(sum);
        }
      }
    }
    int cnt = 0;
    for (int num : numSet) {
//      System.out.println(num + " ");
      cnt++;
      if (cnt == k) {
        answer = num;
        break;
      }
      
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
  }
}
