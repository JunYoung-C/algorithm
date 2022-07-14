package programmers.lv1.같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> numbers = new ArrayList<>();
        int prev = -1;
        for (int num : arr) {
            if (prev != num) {
                prev = num;
                numbers.add(prev);
            }
        }

        int len = numbers.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}