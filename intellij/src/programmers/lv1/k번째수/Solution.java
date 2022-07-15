package programmers.lv1.k번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                numbers.add(array[i]);
            }
            Collections.sort(numbers);
            answer[index++] = numbers.get(command[2] - 1);
        }

        // System.out.println(commands.length);
        return answer;
    }
}
