package strangestr;

class Solution {
  public String solution(String s) {
    StringBuffer answer = new StringBuffer();
    int index = 0;
    for (int i = 0, len = s.length(); i < len; i++) {
      if (s.charAt(i) == ' ') {
        index = 0;
        answer.append(' ');
        continue;
      }
      if (index++ % 2 == 0) {
        answer.append(Character.toUpperCase(s.charAt(i)));
      } else {
        answer.append(Character.toLowerCase(s.charAt(i)));
      }
    }
    return answer.toString();
  }
}
