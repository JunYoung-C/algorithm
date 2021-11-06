package test;

import java.util.ArrayList;

class Solution {
  int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public int solution(int[] arr) {
    int answer = 0;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(arr[0]);
    int len = arr.length;
    for (int i = 1; i < len; i++) {
      int a = list.remove(0);
      int b = arr[i];
      int maxCommon = gcd(Math.max(a, b), Math.min(a, b));
      list.add(a * b / maxCommon);
    }
    answer = list.get(0);
    return answer;
  }
}
