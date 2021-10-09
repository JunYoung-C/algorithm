package tempcap;

import java.util.Scanner;

public class Main {
  // arr[stu][cl]
  public int solution(int n, int[][] arr) {
    int answer = 0;
    int max = Integer.MIN_VALUE; // 같은 반이 돼 본 학생수 
    for (int me = 0; me < n; me++) {
      int[] chkArr = new int[n]; 
      
      // 반마다 같은 학생수 있는지 확인
      for (int cl = 0; cl < 5; cl++) {
        for (int stu = 0; stu < n; stu++) {
          if (arr[me][cl] == arr[stu][cl]) {
            chkArr[stu] = 1;
          }
        }
      }
      
      // 같은 반이 돼본적 있는 학생수 카운팅
      int cnt =  -1;
      for (int i = 0; i < n; i++) {
        if (chkArr[i] == 1) {
          cnt++;
        }
      }
      
      // 같은 반이 돼본적 있는 학생수 최댓값 대입
      if (max < cnt) {
        max = cnt;
        answer = me + 1; // 학생 = 인덱스 + 1
      }
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[][] arr = new int[n][5];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] = stdIn.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
}
