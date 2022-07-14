package programmers.lv1.나누어떨어지는숫자배열;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                numbers.add(num);
            }
        }

        Collections.sort(numbers);
        int len = numbers.size();
        if (len == 0) {
            return new int[] {-1};
        }
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}