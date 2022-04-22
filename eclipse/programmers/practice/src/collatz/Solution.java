package collatz;

class Solution {
  public int solution(int num) {
    int answer = 0;
//    for (int i = 0; i <= 500; i++) {
//      if (num == 1)
//        return i;
//      if (num % 2 == 0) {
//        num /= 2;
//      } else {
//        num = num * 3 + 1;
//      }
//    }
    long n = (long) num;
    while (n != 1) {
      n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
      answer++;
      if (answer > 500)
        return -1;
    }
    return answer;
  }
}
