package programmers.lv1.문자열내림차순;

import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder(new String(charArr));
        return sb.reverse().toString();
    }
}
