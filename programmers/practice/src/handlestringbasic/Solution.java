package handlestringbasic;

class Solution {
  public boolean solution(String s) {
    boolean answer = true;
    if (s.length() != 4 && s.length() != 6) return false;
    if (s.equals("")) return false;
    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return answer;
  }
}
