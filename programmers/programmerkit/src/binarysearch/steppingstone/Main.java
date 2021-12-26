package binarysearch.steppingstone;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int solution(int distance, int[] rocks, int n) {
    // 이분탐색은 오름차순으로 정렬되어있는 경우를 전제로한다.
    Arrays.sort(rocks);
    return binarySearch(distance, rocks, n);
  }

  int binarySearch(int distance, int[] rocks, int n) {
    long ans = 0;
    long lt = 1;
    long rt = distance;
    
    while (lt <= rt) {
      long mid = (lt + rt) / 2;
      int removeCnt = 0;
      int prev = 0;

      for (int now : rocks) {
        if (now - prev < mid) {
          removeCnt++;
        } else {
          prev = now;
        }
      }

      if (distance - prev < mid) {
        removeCnt++;
      }

//      System.out.println(lt + " " + mid + " " + rt + " " + removeCnt + " " + n);

      if (removeCnt <= n) {
        ans = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
    
    return (int) ans;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    int distance = 25;
    int[] rocks = {2, 14, 11, 21, 17};
    int n = 2;
    System.out.println(T.solution(distance, rocks, n));
  }
}

