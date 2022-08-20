package programmers.lv3.스타수열;

import java.util.*;

class Solution {
    ArrayList<Integer> numbers = new ArrayList<>();
    public int solution(int[] a) {
        int answer = -1;
        int len = a.length;
        if (len == 1) {
            return 0;
        } else if (len == 2) {
            if (a[0] == a[1]) {
                return 2;
            } else {
                return 1;
            }
        }

        if (a[0] != a[1]) {
            numbers.add(a[0]);
        }

        for (int i = 1; i < len - 1; i++) {
            if (a[i] == a[i - 1] && a[i] == a[i + 1]) {
                continue;
            }

            numbers.add(a[i]);
        }

        if (a[len - 2] != a[len - 1]) {
            numbers.add(a[len - 1]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }

        answer = max / 2 * 4;
        if (answer > len) {
            answer -= 2;
        }
        return answer;
    }
}
