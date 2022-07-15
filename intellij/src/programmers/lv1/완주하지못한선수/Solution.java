package programmers.lv1.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String s : participant) {
            completionMap.put(s, completionMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (completionMap.get(s) == 1) {
                completionMap.remove(s);
            } else {
                completionMap.put(s, completionMap.get(s) - 1);
            }
        }

        for (String key : completionMap.keySet()) {
            answer = key;
        }

        return answer;
    }
}
