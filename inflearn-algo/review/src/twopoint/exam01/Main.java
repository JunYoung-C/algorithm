package twopoint.exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int[] nArr, int m, int[] mArr) {
    ArrayList<Integer> answer = new ArrayList<>();
    int ni = 0;
    int mi = 0;
    while (ni < n && mi < m) {
      if (nArr[ni] < mArr[mi]) {
        answer.add(nArr[ni++]);
      } else {
        answer.add(mArr[mi++]);
      }
    }
    
    while (ni < n) {
      answer.add(nArr[ni++]);
    }
    
    while (mi < m) {
      answer.add(mArr[mi++]);
    }

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] nArr = new int[n];
    for (int i = 0; i < n; i++) {
      nArr[i] = stdIn.nextInt();
    }
    int m = stdIn.nextInt();
    int[] mArr = new int[m];
    for (int i = 0; i < m; i++) {
      mArr[i] = stdIn.nextInt();
    }
    for (int i : T.solution(n, nArr, m, mArr)) {
      System.out.print(i + " ");
    }
  }
}
