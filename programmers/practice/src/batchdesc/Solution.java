package batchdesc;

import java.util.Arrays;

class Solution {
  public String solution(String s) {
    char[] charArr = s.toCharArray();
    Arrays.sort(charArr);


    StringBuffer sb = new StringBuffer(String.valueOf(charArr)).reverse();
    return sb.toString();
  }
}
