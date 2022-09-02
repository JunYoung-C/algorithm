package programmers.kakao.lv1.성격유형검사하기;

import java.util.*;

class Solution {
    public String solution(String[] surveyArr, int[] choices) {
        String answer = "";
        int[] point = {0, 3, 2, 1, 0, 1, 2, 3};
        String[][] kinds = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] kind : kinds) {
            map.put(kind[0], 0);
            map.put(kind[1], 0);
        }

        int len = surveyArr.length;
        for (int i = 0; i < len; i++) {
            String[] elements = surveyArr[i].split("");
            int choice = choices[i];

            if (choice <= 3) {
                map.put(elements[0], map.get(elements[0]) + point[choice]);
            } else {
                map.put(elements[1], map.get(elements[1]) + point[choice]);
            }
        }

        for (String[] kind : kinds) {
            String lt = kind[0];
            String rt = kind[1];

            if (map.get(lt) >= map.get(rt)) {
                answer += lt;
            } else {
                answer += rt;
            }
        }

        return answer;
    }
}
