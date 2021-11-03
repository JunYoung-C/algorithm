package findprime;

class Solution {
  boolean isPrime(int num) {
    for (int i = 2; i <= (int)Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }
    return true;
  }
  public int solution(int n) {
    int answer = 0;
    for (int num = 2; num <= n; num++) {
      if (isPrime(num)) answer++;
    }
    return answer;
  }
}
