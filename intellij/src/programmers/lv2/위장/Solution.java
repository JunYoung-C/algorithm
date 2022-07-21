package programmers.lv2.위장;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (int value : map.values()) {
            answer *= value + 1;
        }

        return answer - 1;
    }
}
