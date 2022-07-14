package programmers.lv1.제일작은수제거하기;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int num : arr) {
            if (num != min) {
                numbers.add(num);
                System.out.println(num);
            }
        }

        if (numbers.size() == 0) {
            return new int[] {-1};
        }

        int len = numbers.size();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}
