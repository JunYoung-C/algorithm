package minmul;

import java.util.TreeSet;

class Solution {
  int gcd(int p, int q) {
    if (q == 0)
      return p;
    return gcd(q, p % q);
  }

  public int solution(int[] arr) {
    TreeSet<Integer> set = new TreeSet<>();
    int answer = 0;
    for (int i : arr) {
      set.add(i);
    }

    
    while (set.size() > 1) {
      int big = set.pollLast();
      int small = set.pollLast();
      int maxCom = gcd(big, small);
      int minCom = big * small / maxCom;
      set.add(minCom);
    }
    
    answer = set.pollFirst();
    return answer;
  }
}
