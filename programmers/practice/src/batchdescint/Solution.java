package batchdescint;

import java.util.Arrays;
import java.util.Collections;

class Solution {
  public long solution(long n) {
    long answer = 0;
    
    // 내가 짠 코드
//    char[] cArr = Long.toString(n).toCharArray();
//    Arrays.sort(cArr);
//    int len = cArr.length;
//    int lt = 0;
//    int rt = len-1;
//    while (lt < rt) {
//      char tmp = cArr[lt];
//      cArr[lt] = cArr[rt];
//      cArr[rt] = tmp;
//      lt++;
//      rt--;
//    }
//    answer = Long.valueOf(String.valueOf(cArr));
        
    // 다른 방법으로 짜본 코드
    String[] strArr = Long.toString(n).split("");
    Arrays.sort(strArr, Collections.reverseOrder());
    StringBuffer sb = new StringBuffer();
    for (String s : strArr) {
      sb.append(s);
    }

    return Long.parseLong(sb.toString());
  }
}
