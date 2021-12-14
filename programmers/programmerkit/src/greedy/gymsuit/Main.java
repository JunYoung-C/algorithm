package greedy.gymsuit;

import java.util.Scanner;

class Solution {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    // 1. 여벌이 있는 사람과 도난당한 사람을 고려한 배열 생성
    // 편의상 0, n+1, n+1 인덱스 추가
    int[] suits = new int[n + 3];
    for (int i = 0; i <= n + 2; i++) {
      suits[i] = 1;
    }
    for (int l : lost) {
      suits[l] -= 1;
    }
    for (int r : reserve) {
      suits[r] += 1;
    }

    for (int i = 1; i <= n; i++) {
      if (suits[i] != 2)
        continue;

      // 2.1 if 여벌이 있는 사람의 왼쪽 사람만 체육복이 없는 경우, 빌려주기
      if (suits[i - 1] == 0 && suits[i + 1] != 0) {
        suits[i - 1] = 1;
        suits[i] = 1;
      }
      // 2.2 else if 여벌이 있는 사람의 오른쪽 사람만 체육복이 없는 경우, 빌려주기
      else if (suits[i - 1] != 0 && suits[i + 1] == 0) {
        suits[i + 1] = 1;
        suits[i] = 1;
      }
      // 2.3 else if 여벌이 있는 사람 주변에 체육복이 없는 사람이 두명인 경우
      else if (suits[i - 1] == 0 && suits[i + 1] == 0) {
        // 2.3.1 if 오른쪽으로 한칸 건너뛴 사람이 여벌이 있는 경우, 왼쪽 사람에게 빌려주기
        if (suits[i + 2] == 2) {
          suits[i - 1] = 1;
        }
        // 2.3.2 else 오른쪽 사람에게 빌려주기
        else {
          suits[i + 1] = 1;
        }
        suits[i] = 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (suits[i] != 0)
        answer += 1;
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // 1
//    int n = 5;
//    int[] lost = new int[] {2, 4};
//    int[] reserve = new int[] {1, 3, 5};

    // 2
     int n = 5;
     int[] lost= new int[] {2, 4};
     int[] reserve = new int[] {3};

    System.out.println(T.solution(n, lost, reserve));
  }
}
