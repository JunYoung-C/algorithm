package programmers.level2.ex1;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char firstChar = words[0].charAt(words[0].length() - 1);
        ArrayList<String> usedWords = new ArrayList<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            // firstChar와 words[i].charAt(0)을 비교, 중복 검증
            if (words[i].charAt(0) != firstChar || usedWords.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }

            firstChar = words[i].charAt(words[i].length() - 1);
            usedWords.add(words[i]);
        }

        System.out.println(firstChar);

        return new int[] {0, 0};
    }
}