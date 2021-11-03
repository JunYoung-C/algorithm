package cissorcode;

class Solution {
  public String solution(String s, int n) {
    StringBuffer answer = new StringBuffer();

    for (char c : s.toCharArray()) {
      
      if (c == ' ') {
        answer.append(' ');
      } else if (Character.isLowerCase(c)) {
        int index = (c - 'a' + n) % 26;
        answer.append((char)(index + 'a'));
      } else if (Character.isUpperCase(c)) {
        int index = (c - 'A' + n) % 26;
        answer.append((char)(index + 'A'));
      }
    }
    return answer.toString();
  }
  
  public static void main(String[] args) {
    Solution T = new Solution();
    System.out.println(T.solution("AB", 1));
  }
}
