package twopoint.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public int[] solution(int n1, int[] arr1, int n2, int[] arr2) {
    int[] answer = {};
    ArrayList<Integer> sameNums = new ArrayList<Integer>();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int i2 = 0;
    for (int i1 = 0; i1 < n1; i1++) {
      if (arr1[i1] < arr2[i2]) {
        continue;
      }
      
      while (arr1[i1] > arr2[i2]) {
        i2++;
        if (i2 >= n2) {
          break;
        }
      }

      if (i2 >= n2) {
        break;
      }
      
      if (arr1[i1] == arr2[i2]) {
        sameNums.add(arr1[i1]);
        i2++;
        continue;
      }
    }
    
    int len = sameNums.size();
    answer = new int[len];
    for (int i = 0; i < len; i++) {
      answer[i] = sameNums.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n1 = stdIn.nextInt();
    int[] arr1 = new int[n1];
    for (int i = 0; i < n1; i++) {
      arr1[i] = stdIn.nextInt();
    }

    int n2 = stdIn.nextInt();
    int[] arr2 = new int[n2];
    for (int i = 0; i < n2; i++) {
      arr2[i] = stdIn.nextInt();
    }

    for (int i : T.solution(n1, arr1, n2, arr2)) {
      System.out.print(i + " ");
    }
  }
}
