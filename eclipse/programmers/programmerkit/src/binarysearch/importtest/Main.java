package binarysearch.importtest;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public long solution(int n, int[] times) {
    long answer = 0;
    Arrays.sort(times);
    long lt = 1;
    long rt = (long) n * times[times.length - 1];
    while (lt <= rt) {
      long mid = (lt + rt) / 2;
      long cnt = countTest(mid, times);
      if (cnt >= n) {
        rt = mid - 1;
        answer = mid;
      } else {
        lt = mid + 1;
      }
    }

    return answer;
  }

  long countTest(long num, int[] times) {
    long cnt = 0;
    for (int time : times) {
      cnt += num / time;
    }
    return cnt;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    // int n = 6;
    // int[] times = {7, 10};

    int n = 7;
    int[] times = {4, 5, 6};

    System.out.println(T.solution(n, times));
  }
}

