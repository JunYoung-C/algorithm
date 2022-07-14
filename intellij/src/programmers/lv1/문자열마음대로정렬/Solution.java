package programmers.lv1.문자열마음대로정렬;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (str1.charAt(n) == str2.charAt(n)) {
                    return str1.compareTo(str2);
                }
                return str1.charAt(n) - str2.charAt(n);
            }
        });
        return strings;
    }
}