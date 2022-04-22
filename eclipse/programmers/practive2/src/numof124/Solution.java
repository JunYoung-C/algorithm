package numof124;

import java.util.Scanner;

class Solution {
  public String solution(int n) {
    StringBuffer answer = new StringBuffer();
    int[] numbers = {1, 2, 4};
    int num = n;
    while (num > 0) {
      num = num - 1;
      
      answer.append(numbers[num%3]);
      num /= 3;
    }
    answer.reverse();
    return answer.toString();
  }
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    System.out.println(T.solution(n));
  }
}
