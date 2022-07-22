package programmers.lv2.큰수만들기;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] charArr = number.toCharArray();
        int len = number.length();
        int removeCount = 0;

        int lt = 0, rt = 0;
        while (removeCount < k && rt < len) {
            if (lt >= rt) {
                rt++;
                continue;
            }

            if (charArr[lt] >= charArr[rt]) {
                while (++lt < len && charArr[lt] == ' ') {
                }
                while (++rt < len && charArr[rt] == ' ') {
                }
            } else {
                charArr[lt] = ' ';
                removeCount++;

                while (lt >= 0 && charArr[lt] == ' ') {
                    lt--;
                }

                if (lt == -1) {
                    lt = rt;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int count = len - k;
        for (char c : charArr) {
            if (c == ' ') {
                continue;
            }
            answer.append(c);
            if (--count <= 0) {
                break;
            }
        }

        return answer.toString();
    }
}
