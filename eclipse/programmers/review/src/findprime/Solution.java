package findprime;

import java.util.ArrayList;

class Solution {
  int answer, len;
  int[] ch;
  ArrayList<Integer> arr = new ArrayList<>();
  void dfs(int L, String sum, String[] num) {
    if (len == L) {
      if (sum == "") return;
      int number = Integer.parseInt(sum);
      if (isPrime(number) && !arr.contains(number)) {
        arr.add(number);
        answer++;
      }
    } else {
      for (int i = 0; i<len; i++) {
        if (ch[i] == 0) {
          ch[i] = 1;
          dfs(L+1, sum + num[i], num);
          ch[i] = 0;
        }
        dfs(L+1, sum, num);
      }
    }
  }
  boolean isPrime(int num) {
    if (num <= 1) return false; 
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
  public int solution(String numbers) {
    answer = 0;
    len = numbers.length();
    ch = new int[len];
    dfs(0, "", numbers.split(""));
 
    return answer;
  }
}
