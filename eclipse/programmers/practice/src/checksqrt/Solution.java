package checksqrt;

class Solution {
  public long solution(long n) {
      long sqrt = (long)Math.floor(Math.sqrt(n));
      if (sqrt * sqrt == n) {
        return (sqrt+1)*(sqrt+1);
      } else {
        return -1;
      }

  }
}
