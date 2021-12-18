package hash.bestalbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Music implements Comparable<Music>{
  int index;
  String genre;
  int play;
  
  public Music(String genre, int play) {
    this.genre = genre;
    this.play = play;
  }

  public Music(int index, String genre, int play) {
    this.index = index;
    this.genre = genre;
    this.play = play;
  }
  @Override
  public int compareTo(Music o) {
    return o.play - this.play;
  }
  
}

class Solution {
  public int[] solution(String[] genres, int[] plays) {
    int[] answer = {};
    ArrayList<Integer> arr = new ArrayList<>();
    int len = genres.length;
    ArrayList<Music> totalPlay = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    
    // 각 장르별로 값을 더한 후 내림차순
    for (int i = 0; i < len; i++) {
      map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
    }
    for (String key : map.keySet()) {
      totalPlay.add(new Music(key, map.get(key)));
    }
    
    Collections.sort(totalPlay);
    
    // 플레이수가 높은 장르순으로 음악 선택
    ArrayList<Music> musics = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      musics.add(new Music(i, genres[i], plays[i]));
    }
    Collections.sort(musics);
    
    for (Music selectedMusic : totalPlay) {
      String selectedGenre = selectedMusic.genre;
      int cnt = 0;
      for (int i = 0; i < len; i++) {
        Music tmpMusic = musics.get(i);
        if (tmpMusic.genre.equals(selectedGenre)) {
          cnt++;
          arr.add(tmpMusic.index);
        }
        
        if (cnt >= 2) break;
      }
    }
    
    answer = new int[arr.size()];
    int idx = 0;
    for (int num : arr) {
      answer[idx++] = num;
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};

    for (int i : T.solution(genres, plays)) {
      System.out.print(i + " ");
    }
  }
}
