package array.exam08;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public int[] solution(int n, Integer[] arr) {
    int[] answer = new int[n];
    Integer[] reversedArr = arr.clone();
    Arrays.sort(reversedArr, Collections.reverseOrder());
    HashMap<Integer, Integer> map = new HashMap<>();
    int rank = 1;
    for (int num : reversedArr) {
      if (map.get(num) == null) {
        map.put(num, rank);
      } 
      rank++;
    }
    for (int i = 0; i < n; i++) {
      answer[i] = map.get(arr[i]);
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    for (int i : T.solution(n, arr)) {
      System.out.print(i + " ");
    }
  }
}
