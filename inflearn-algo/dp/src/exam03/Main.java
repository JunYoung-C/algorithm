package exam03;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[] arr) {
    int answer = 0;
    // 왜 틀린지 모르겠다.
    // for (int start = 0; start < n; start++) {
    // int cnt = 1;
    // int min = arr[start];
    // for (int i = start+1; i < n; i++) {
    // if (arr[i] > min) {
    // cnt++;
    // min = arr[i];
    // }
    // }
    // answer = Math.max(answer, cnt);
    // }

    int[] dy = new int[arr.length];
    dy[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i] && dy[j] > max)
          max = dy[j];
      }
      dy[i] = max + 1;
      answer = Math.max(answer, dy[i]);
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
    System.out.println(T.solution(n, arr));
  }
}
