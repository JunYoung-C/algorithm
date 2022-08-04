package programmers.kakao.lv2.뉴스클러스터링;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int MUL = 65536;
        HashMap<String, Integer> str1Map = createStrMap(str1);
        HashMap<String, Integer> str2Map = createStrMap(str2);
        HashMap<String, Integer> maxMap = new HashMap<>();
        HashMap<String, Integer> minMap = new HashMap<>();

        if (str1Map.isEmpty() && str2Map.isEmpty()) {
            return MUL;
        }

        for (String key : str1Map.keySet()) {
            maxMap.put(key, str1Map.get(key));
        }

        for (String key : str2Map.keySet()) {
            if (maxMap.containsKey(key)) {
                maxMap.put(key, Math.max(str1Map.get(key), str2Map.get(key)));
                minMap.put(key, Math.min(str1Map.get(key), str2Map.get(key)));
            } else {
                maxMap.put(key, str2Map.get(key));
            }
        }

        int min = 0;
        int max = 0;
        for (int value : maxMap.values()) {
            max += value;
        }

        for (int value : minMap.values()) {
            min += value;
        }

        return min * MUL / max;
    }

    private HashMap<String, Integer> createStrMap(String str) {
        HashMap<String, Integer> strMap = new HashMap<>();
        String substring;
        for (int i = 0; i < str.length() - 1; i++) {
            if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                substring = str.substring(i, i + 2).toLowerCase();
                strMap.put(substring, strMap.getOrDefault(substring, 0) + 1);
            }
        }

        return strMap;
    }

    private boolean isAlphabet(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }

        return false;
    }
}
