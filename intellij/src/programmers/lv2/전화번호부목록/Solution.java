package programmers.lv2.전화번호부목록;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        int len = phone_book.length;
        for (int i = 1; i < len; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }

        return answer;
    }
}
