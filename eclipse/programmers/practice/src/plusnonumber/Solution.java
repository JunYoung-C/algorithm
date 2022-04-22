package plusnonumber;

class Solution {
  public int solution(int[] numbers) {
    int answer = 0;
    int[] ch = new int[10];
    for (int i : numbers) {
      ch[i] = 1;
    }
    for (int i = 0; i < 10; i++) {
      if (ch[i] == 0) {
        answer += i;
      }
    }
    return answer;
  }
}
