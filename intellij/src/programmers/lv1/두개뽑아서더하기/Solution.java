package programmers.lv1.두개뽑아서더하기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> sums = new ArrayList<>();
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!sums.contains(numbers[i] + numbers[j])) {
                    sums.add(numbers[i] + numbers[j]);
                }
            }
        }
        Collections.sort(sums);
        len = sums.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = sums.get(i);
        }
        return answer;
    }
}
