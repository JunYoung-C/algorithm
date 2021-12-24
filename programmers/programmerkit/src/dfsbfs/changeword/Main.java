package dfsbfs.changeword;

import java.util.Scanner;

class Solution {
  boolean[] isVisited;
  int len;
  int answer = Integer.MAX_VALUE;

  public int solution(String begin, String target, String[] words) {
    len = words.length;
    isVisited = new boolean[len];
    dfs(begin, target, words, 0);

    if (answer == Integer.MAX_VALUE)
      answer = 0;
    return answer;
  }

  void dfs(String begin, String target, String[] words, int cnt) {
    if (begin.equals(target)) {
      answer = Math.min(answer, cnt);
    } else {
      for (int i = 0; i < len; i++) {
        if (!isVisited[i] && isPossibleWord(begin, words[i])) {
          isVisited[i] = true;
          dfs(words[i], target, words, cnt + 1);
          isVisited[i] = false;
        }
      }
    }
  }

  boolean isPossibleWord(String word, String selectedWord) {
    boolean ans = true;
    int wordLen = word.length();
    int diffCnt = 0;

    for (int i = 0; i < wordLen; i++) {
      if (word.charAt(i) != selectedWord.charAt(i)) {
        diffCnt++;
      }
    }

    if (diffCnt > 1) {
      ans = false;
    }
    return ans;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//    String begin = "hit";
//    String target = "cog";
//    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

     String begin = "hit";
     String target = "cog";
     String[] words = {"hot", "dot", "dog", "lot", "log"};
    System.out.println(T.solution(begin, target, words));
  }
}
