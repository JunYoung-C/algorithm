package array.exam11;

import java.util.Scanner;

public class Main {
  public int solution(int n, int[][] arr) {
    int answer = 0;
    int[] cnts = new int[n + 1];
    for (int me = 1; me <= n; me++) {
      int[] ch = new int[n + 1];
      int cnt = 0;
      
      for (int cla = 1; cla < 6; cla++) {
        // me마다 같은반 학생수 확인
        for (int stu = 1; stu <= n; stu++) {
          if (arr[me][cla] == arr[stu][cla]) {
            ch[stu] = 1;
          }
        }
       
      }
      
      // me의 같은반 학생수 카운팅
      for (int i : ch) {
        cnt += i;
      }
      cnts[me] = cnt;
    }
    
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      if (cnts[i] > max) {
        max = cnts[i];
        answer = i;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[][] arr = new int[n + 1][6];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < 6; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
}
