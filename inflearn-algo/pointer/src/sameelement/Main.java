package sameelement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int[] nNums, int m, int[] mNums) {
    ArrayList<Integer> answer = new ArrayList<>();
    Arrays.sort(nNums);
    Arrays.sort(mNums);
    int ni = 0, mi = 0;
    while (ni < n && mi < m) {
      if (nNums[ni] == mNums[mi]) {
        answer.add(nNums[ni]);
        ni++;
        mi++;
      } else if (nNums[ni] < mNums[mi]) {
        ni++;
      } else {
        mi++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] nNums = new int[n];
    for (int i = 0; i < n; i++) {
      nNums[i] = stdIn.nextInt();
    }
    
    int m = stdIn.nextInt();
    int[] mNums = new int[m];
    for (int i = 0; i < m; i++) {
      mNums[i] = stdIn.nextInt();
    }

    for (int i: T.solution(n, nNums, m, mNums)) {
      System.out.print(i + " ");
  }
}
}
