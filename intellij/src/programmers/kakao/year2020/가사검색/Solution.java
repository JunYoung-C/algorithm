package programmers.kakao.year2020.가사검색;

import java.util.HashMap;

class Trie {
    Trie[] child = new Trie[26];
    int count;

    public Trie() {
    }

    public void add(String str) {
        Trie current = this;
        int index = 0;
        current.count++;

        while (index < str.length()) {
            char c = str.charAt(index++);

            if (current.child[c - 'a'] == null) {
                current.child[c - 'a'] = new Trie();
            }

            current = current.child[c - 'a'];
            current.count++;
        }
    }

    public int getCount(String str) {
        Trie current = this;
        int index = 0;

        while (index < str.length()) {
            char c = str.charAt(index++);

            if (c == '?') {
                return current.count;
            } else {
                current = current.child[c - 'a'];
            }

            if (current == null) {
                return 0;
            }
        }

        return current.count;
    }
}

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int len = queries.length;
        int[] answer = new int[len];

        HashMap<Integer, Trie> wordTrieMap = new HashMap<>();
        HashMap<Integer, Trie> reversedWordTrieMap = new HashMap<>();

        for (String word : words) {
            addWordEntry(wordTrieMap, word);
            addWordEntry(reversedWordTrieMap, reverse(word));
        }

        for (int i = 0; i < len; i++) {
            String query = queries[i];

            if (query.charAt(0) == '?') {
                if (reversedWordTrieMap.containsKey(query.length())) {
                    answer[i] = reversedWordTrieMap.get(query.length()).getCount(reverse(query));
                }
            } else {
                if (wordTrieMap.containsKey(query.length())) {
                    answer[i] = wordTrieMap.get(query.length()).getCount(query);
                }
            }
        }

        return answer;
    }

    private static void addWordEntry(HashMap<Integer, Trie> wordTrieMap, String word) {
        int wordLen = word.length();

        if (!wordTrieMap.containsKey(wordLen)) {
            wordTrieMap.put(wordLen, new Trie());
        }

        wordTrieMap.get(wordLen).add(word);
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
