package programmers.lv2.모음사전;

import java.util.*;

class Solution {
    ArrayList<String> words = new ArrayList<>();
    char[] charArr = {'A', 'E', 'I', 'O', 'U'};
    HashSet<String> wordSet = new HashSet<>();

    public int solution(String word) {
        dfs("", 0);
        for (String s : wordSet) {
            words.add(s);
        }
        Collections.sort(words);
        return words.indexOf(word) + 1;
    }

    private void dfs(String word, int depth) {
        if (!word.equals("")) {
            wordSet.add(word);
        }

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < charArr.length; i++) {
            dfs(word + charArr[i], depth + 1);
        }

    }
}
