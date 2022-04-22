package perfactsearch.findPrime;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  ArrayList<Integer> arr = new ArrayList<>();
  boolean[] isVisited;
  boolean isPrime(int num) {
    if (num < 2) return false;
    
    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
  
  void dfs(int L, String sumStr, String numbers, int len) {
    if (L == len) {
      if (sumStr == "") return;
      
      int num = Integer.parseInt(sumStr);
      if (!arr.contains(num) && isPrime(num)) {
        arr.add(num);
      }
    } else {
      for (int i = 0; i < len; i++) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          
          dfs(L + 1, sumStr + numbers.charAt(i), numbers, len);
          dfs(L + 1, sumStr, numbers, len);

          isVisited[i] = false;
        }
      }
    }
  }
  
  public int solution(String numbers) {
      int answer = 0;
      int len = numbers.length();
      isVisited = new boolean[len];
      
      dfs(0, "", numbers, len);
      
      answer = arr.size();
      return answer;
  }
}

public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
//    String numbers = "17";
    String numbers = "011";
    System.out.println(T.solution(numbers));
  }
}
