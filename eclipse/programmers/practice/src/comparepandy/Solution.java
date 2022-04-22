package comparepandy;

class Solution {
  boolean solution(String s) {
    int pCnt = 0;
    int yCnt = 0;
    for (char c : s.toUpperCase().toCharArray()) {
      if (c == 'P') {
        pCnt++;
      }
      if (c == 'Y') {
        yCnt++;
      }
    }
    
    if (pCnt == yCnt) {
      return true;
    } else {
      return false;
    }
  }
}
