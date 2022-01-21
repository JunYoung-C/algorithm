package array.ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] arr) {
    int[] answer = {};
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    arrList.add(arr[0]);
    
    for (int i = 1; i < n; i++) {
      if (arr[i - 1] < arr[i]) {
        arrList.add(arr[i]);
      }
    }

    int len = arrList.size();
    answer = new int[len];
    int i = 0;
    for (int num : arrList) {
      answer[i++] = num;
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
