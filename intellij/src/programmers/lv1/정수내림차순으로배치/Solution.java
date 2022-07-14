package programmers.lv1.정수내림차순으로배치;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] charArr = String.valueOf(n).toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder(new String(charArr));

        return Long.parseLong(sb.reverse().toString());
    }
}
