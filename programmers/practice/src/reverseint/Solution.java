package reverseint;

class Solution {
  public int[] solution(long n) {
    int[] answer = {};
    StringBuffer sb = new StringBuffer(String.valueOf(n)).reverse();
    String[] str = sb.toString().split("");
    answer = new int[str.length];
    for (int i = 0; i < str.length; i++) {
      answer[i] = Integer.parseInt(str[i]);
    }

    return answer;
  }
}
