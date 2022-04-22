package maxmin;

class Solution {
  public String solution(String s) {
    String answer = "";
    String[] strArr = s.split(" ");
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (String str : strArr) {
      min = Math.min(min, Integer.parseInt(str));
      max = Math.max(max,  Integer.parseInt(str));
    }
    answer = min + " " + max;
    return answer;
  }
}
