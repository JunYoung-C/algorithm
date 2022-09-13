package programmers.kakao.lv3.카카오보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int len = gems.length;
        int[] answer = {1, len};
        int typeCount = getTypeCount(gems);

        int lt = 0, rt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (rt < len) {
            if (map.size() < typeCount) {
                map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);
                rt++;
            }

            while (map.size() >= typeCount) {
                if (rt - lt < answer[1] - answer[0] + 1) {
                    answer[0] = lt + 1;
                    answer[1] = rt;
                }

                map.put(gems[lt], map.get(gems[lt]) - 1);
                if (map.get(gems[lt]) == 0) {
                    map.remove(gems[lt]);
                }
                lt++;
            }
        }

        return answer;
    }

    private int getTypeCount(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String g : gems) {
            map.put(g, map.getOrDefault(g, 0) + 1);
        }

        return map.size();
    }
}