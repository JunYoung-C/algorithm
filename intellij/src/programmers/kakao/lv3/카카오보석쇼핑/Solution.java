package programmers.kakao.lv3.카카오보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = 100002;
        int count = getKindCount(gems);
        int lt = 0, rt = 0;
        int len = gems.length;
        HashMap<String, Integer> map = new HashMap<>();
        while (rt < len) {
            if (map.size() < count) {
                map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);
                rt++;
            } else if (map.size() == count) {
                // System.out.println(lt + 1 + " " + rt);
                if (answer[1] - answer[0] > rt - lt - 1) {
                    answer[0] = lt + 1;
                    answer[1] = rt;
                }

                map.put(gems[lt], map.get(gems[lt]) - 1);
                if (map.get(gems[lt]) == 0) {
                    map.remove(gems[lt]);
                }
                lt++;
            } else {
                map.put(gems[lt], map.get(gems[lt]) - 1);
                if (map.get(gems[lt]) == 0) {
                    map.remove(gems[lt]);
                }
                lt++;
            }
        }
        // if (map.size() == count) {
        //     System.out.println(lt + 1 + " " + rt);
        // }

        while (map.size() == count) {
            if (answer[1] - answer[0] > rt - lt - 1) {
                answer[0] = lt + 1;
                answer[1] = rt;
            }

            map.put(gems[lt], map.get(gems[lt]) - 1);
            if (map.get(gems[lt]) == 0) {
                map.remove(gems[lt]);
            }
            lt++;
        }

        // System.out.println(count);
        return answer;
    }

    private int getKindCount(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }

        return map.size();
    }
}
