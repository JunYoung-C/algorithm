package maxmaxnum;

import java.util.ArrayList;


class Solution {
  // 내가 짠 코드
  // int findMax(ArrayList<Integer> nArr, ArrayList<Integer> mArr) {
  // for (int ni : nArr) {
  // for (int mi : mArr) {
  // if (ni == mi) {
  // return ni;
  // }
  // }
  // }
  // return 1;
  // }
  int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public int[] solution(int n, int m) {
    int[] answer = {};
    // ArrayList<Integer> nArr = new ArrayList<>();
    // ArrayList<Integer> mArr = new ArrayList<>();
    // for (int i = n; i > 0; i--) {
    // if (n % i == 0)
    // nArr.add(i);
    // }
    // for (int i = m; i > 0; i--) {
    // if (m % i == 0)
    // mArr.add(i);
    // }
    // int max = findMax(nArr, mArr);
    int max = gcd(Integer.max(n, m), Integer.min(n, m));
    int min = max * (n / max) * (m / max);
    answer = new int[] {max, min};
    return answer;
  }
}
