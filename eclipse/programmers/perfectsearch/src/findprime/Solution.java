package findprime;

import java.util.ArrayList;

class Solution {
  int answer = 0;
  char[] numArr;
  boolean[] ch = new boolean[10];
  ArrayList<Integer> primes = new ArrayList<>();
  
  boolean isPrime(int n) {
    if (n <= 1) return false;
    int limit = (int) Math.sqrt(n);
    for (int i = 2; i < limit +1; i++) {
      if (n % i == 0) return false;
    }
      
      return true;
  }
  
  public void dfs(int L, int len, String str) {
    if (L == len) {
      if (str == "") return;
      
      System.out.println(str);
      int num = Integer.parseInt(str);
      
      if (isPrime(num) && !primes.contains(num)) {
        primes.add(num);
      }
    } else {
      for (int i = 0; i < len; i++) {
        if (!ch[i]) {
          ch[i] = true;
          dfs(L + 1, len, str + numArr[i]);
          ch[i] = false;
          dfs(L + 1, len, str);
        }
      }
    }
  }

  public int solution(String numbers) {
    numArr = numbers.toCharArray();
    int len = numArr.length;
    String tmp = "";
    dfs(0, len, tmp);
    answer = primes.size();
    return answer;
  }
  
  public static void main(String[] args) {
    Solution T = new Solution();
    String numbers = "0112";
    
    System.out.println(T.solution(numbers));
  }
}
