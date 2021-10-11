package plustwoarray;

import java.util.Scanner;

public class Main {
  public int[] solution(int n, int[] nNums, int m, int[] mNums) {
    int len = n + m;
    int[] answer = new int[len];
    
    int i;
    int nI = 0, mI = 0;
    for (i = 0; i < len; i++) {
      if (nI >= n || mI >= m) {
        break;
      }
      
      if (nNums[nI] > mNums[mI]) {
        answer[i] = mNums[mI];
        mI++;
      } else {
        answer[i] = nNums[nI];
        nI++;
      }

    }
    
    while (nI <= n-1) {
      answer[i] = nNums[nI];
      nI++;
      i++;
    } 
    
    while (mI <= m-1) {
      answer[i] = mNums[mI];
      mI++;
      i++;
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
