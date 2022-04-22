package presentnum;

class Solution {
  public int solution(int n) {
    int answer = 0;
    int cnt = 0;
    int num = n;
    while (true) {
      num -= cnt;
      if (num <= 0) return answer;
      if (num % (cnt+1) == 0) {
        System.out.println(num);
        answer++;
      }
      cnt++;
    }
  }
}
