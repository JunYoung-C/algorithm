package programmers.lv3.단어변환;

class Solution {
    boolean[] isVisited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        dfs(begin, target, words, 0);

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    private void dfs(String current, String target, String[] words, int count) {
        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && getWrongCount(current, words[i]) == 1) {
                isVisited[i] = true;
                dfs(words[i], target, words, count + 1);
                isVisited[i] = false;
            }
        }
    }

    private int getWrongCount(String str1, String str2) {
        int len = str1.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
