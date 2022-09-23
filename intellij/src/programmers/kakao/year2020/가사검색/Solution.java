package programmers.kakao.year2020.가사검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        HashMap<Integer, ArrayList<String>> reversedWordsMap = new HashMap<>(), wordsMap = new HashMap<>();
        initMap(words, reversedWordsMap, wordsMap);

        for (int i = 0; i < len; i++) {
            String query = queries[i];
            ArrayList<String> wordList;

            if (query.charAt(0) == '?') {
                if (!reversedWordsMap.containsKey(query.length())) {
                    continue;
                } else {
                    wordList = reversedWordsMap.get(query.length());
                    query = reverse(query);
                }
            } else {
                if (!wordsMap.containsKey(query.length())) {
                    continue;
                } else {
                    wordList = wordsMap.get(query.length());
                }
            }

            answer[i] = getUpperIndex(wordList, query.replace('?', 'z'))
                    - getLowerIndex(wordList, query.replace('?', 'a')) + 1;
        }

        return answer;
    }

    private int getUpperIndex(ArrayList<String> words, String target) {
        int lt = 0, rt = words.size() - 1;
        int index = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (target.compareTo(words.get(mid)) < 0) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                index = mid;
            }
        }

        return index;
    }

    private int getLowerIndex(ArrayList<String> words, String target) {
        int lt = 0, rt = words.size() - 1;
        int index = words.size();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (target.compareTo(words.get(mid)) <= 0) {
                rt = mid - 1;
                index = mid;
            } else {
                lt = mid + 1;
            }
        }

        return index;
    }

    private void sortMap(HashMap<Integer, ArrayList<String>> wordsMap) {
        for (ArrayList<String> words : wordsMap.values()) {
            Collections.sort(words);
        }
    }

    private void initMap(String[] words, HashMap<Integer, ArrayList<String>> reversedWordsMap, HashMap<Integer, ArrayList<String>> wordsMap) {
        for (String word : words) {
            int wordLen = word.length();
            if (!wordsMap.containsKey(wordLen)) {
                wordsMap.put(wordLen, new ArrayList<>());
            }

            if (!reversedWordsMap.containsKey(wordLen)) {
                reversedWordsMap.put(wordLen, new ArrayList<>());
            }

            wordsMap.get(wordLen).add(word);
            reversedWordsMap.get(wordLen).add(reverse(word));
        }

        sortMap(wordsMap);
        sortMap(reversedWordsMap);
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        for (int i : T.solution(words, queries)) {
            System.out.print(i + " ");
        }
    }
}
