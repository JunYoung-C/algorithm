package programmers.lv2.hindex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int answer = len;
        for (int i = 0; i < len; i++) {
            if (answer <= citations[i]) {
                break;
            }
            answer--;
        }
        return answer;
    }
}
