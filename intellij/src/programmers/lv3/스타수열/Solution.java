package programmers.lv3.스타수열;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = -1;
        if (a.length == 1) {
            return 0;
        } else if (a.length == 2) {
            if (a[0] == a[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> numbers = new ArrayList<>(map.keySet());
        Collections.sort(numbers, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        for (int num : numbers) {
            if (map.get(num) <= 1 ) {
                break;
            }

            boolean keepNum = false;
            boolean keepOtherNum = false;

            int count = 0;
            for (int i : a) {
                if (i == num) {
                    if (keepOtherNum) {
                        count += 2;
                        keepNum = false;
                        keepOtherNum = false;
                    } else {
                        keepNum = true;
                    }
                } else {
                    if (keepNum) {
                        count += 2;
                        keepNum = false;
                        keepOtherNum = false;
                    } else {
                        keepOtherNum = true;
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
