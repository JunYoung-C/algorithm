package programmers.lv2.가장큰수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        int len = numbers.length;
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, (s1, s2) -> {
                    return (s2 + s1).compareTo(s1 + s2);
                }
        );

        for (String s : strings) {
            answer.append(s);
        }

        return answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }
}
