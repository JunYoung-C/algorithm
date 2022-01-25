package sort.ex06;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public int[] solution(int n, int[] heights) {
    int[] answer = new int[2]; //철수(키큼), 짝꿍
    int[] copy = heights.clone();
    Arrays.sort(copy);
    int idx = 0;
    for (int i = 1; i <= n; i++) {
      if (heights[i] != copy[i]) {
        answer[idx++] = i;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int[] heights = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      heights[i] = stdIn.nextInt();
    }

    for (int i : T.solution(n, heights)) {
      System.out.print(i + " ");
    }
  }
}
