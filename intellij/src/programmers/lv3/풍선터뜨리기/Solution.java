package programmers.lv3.풍선터뜨리기;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                set.add(i);
                min = a[i];
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (min > a[i]) {
                set.add(i);
                min = a[i];
            }
        }
        return set.size();
    }
}
