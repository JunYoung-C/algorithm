package exam06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    int[] arrCopy = arr.clone();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      if (arrCopy[i] != arr[i]) {
        answer.add(i + 1);
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
    for (int i : T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}
