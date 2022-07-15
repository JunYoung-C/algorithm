package programmers.lv1.모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[4]; // X, 1번, 2번, 3번
        int[][] solves = {{},
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for (int person = 1; person <= 3; person++) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == solves[person][i % solves[person].length]) {
                    answer[person]++;
                }
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();
        int len = 0;
        for (int i = 1; i <= 3; i++) {
            if (answer[i] == max) {
                len++;
            }
        }

        int[] people = new int[len];
        int index = 0;
        for (int i = 1; i <= 3; i++) {
            if (answer[i] == max) {
                people[index++] = i;
            }
        }
        return people;
    }
}
