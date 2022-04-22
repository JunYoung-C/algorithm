package makejadencase;

class Solution {
  public String solution(String s) {
    String answer = "";
    char[] strArr = s.toCharArray();
    int index = 0;
    int len = s.length();
    for (int i = 0; i < len; i++) {
     if (Character.isAlphabetic(strArr[i])) {
       if (index == 0) {
         strArr[i] = Character.toUpperCase(strArr[i]);
       }  else {
         strArr[i] = Character.toLowerCase(strArr[i]);
       }
      }

      index++;
      
      if (strArr[i] == ' ')
        index = 0;
    }

    answer = String.valueOf(strArr);
    return answer;
  }
}
