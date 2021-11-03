package changeword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  ArrayList<String> changableWords(String word, String[] words) {
    ArrayList<String> arr = new ArrayList<>();
    for (String selectedWord : words) {
      int cnt = 0;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != selectedWord.charAt(i)) cnt++;
      }
      if (cnt == 1) {
        arr.add(selectedWord);
      }
    }

    
    return arr;
  }
  int bfs(String begin, String target, String[] words) {
    int cnt = 0;
    HashSet<String> ch = new HashSet<>();
    Queue<String> que = new LinkedList<>();
    que.offer(begin);
    ch.add(begin);
    
    while (!que.isEmpty()) {
      int len = que.size();
      for (int i = 0; i < len; i++) {
        String word = que.poll();
        for (String changableWord : changableWords(word, words)) {
          if (changableWord.equals(target)) {
            return cnt+1;
          }
          if (!ch.contains(changableWord)) {
            ch.add(changableWord);
            que.offer(changableWord);
          }
        }
      }
      cnt++;
    }
    
    return 0;
  }
  public int solution(String begin, String target, String[] words) {
      int answer = bfs(begin, target, words);
      return answer;
  }
}
