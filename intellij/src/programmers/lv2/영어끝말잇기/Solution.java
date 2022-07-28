package programmers.lv2.영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int len = words.length;
        HashMap<String, Boolean> wordsMap = new HashMap<>();
        wordsMap.put(words[0], true);
        String word;
        for (int i = 1; i < len; i++) {
            word = words[i];
            if (!isValidStart(words[i - 1], word) || isDuplicatedWord(word, wordsMap)) {
                System.out.println(word);
                return new int[] {i % n + 1, i / n + 1};
            }

            wordsMap.put(words[i], true);
        }


        return answer;
    }

    private boolean isDuplicatedWord(String word, HashMap<String, Boolean> wordsMap) {
        return wordsMap.containsKey(word);
    }

    private boolean isValidStart(String prevWord, String word) {
        return prevWord.charAt(prevWord.length() - 1) == word.charAt(0);
    }
}
