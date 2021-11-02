package bestalbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Music implements Comparable<Music> {
  int index;
  String genre;
  int play;

  Music(int index, String genre, int play) {
    this.index = index;
    this.genre = genre;
    this.play = play;
  }

  @Override
  public int compareTo(Music o) {
    if (o.play == this.play)
      return this.index - o.index;
    return o.play - this.play;
  }
}


class Solution {
  public int[] solution(String[] genres, int[] plays) {
    ArrayList<Integer> answerList = new ArrayList<>();
    int[] answer;
    int len = genres.length;
    ArrayList<Music> arr = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
      arr.add(new Music(i, genres[i], plays[i]));
    }

    Collections.sort(arr);

    while (map.size() != 0) {
      int max = Integer.MIN_VALUE;
      String maxGenre = "";

      // 플레이수 높은 장르 구한 후 map에서 제거
      for (String genre : map.keySet()) {
        if (map.get(genre) > max) {
          max = map.get(genre);
          maxGenre = genre;
        }
      }
      map.remove(maxGenre);
      
      // 플레이수 높은 장르로 두곡 수록
      int cnt = 0;
      for (Music music : arr) {
        if (music.genre.equals(maxGenre)) {
          answerList.add(music.index);
          cnt++;
          if (cnt == 2) {
            break;
          }
        }
      }
    }
    
    int n = answerList.size();
    answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

}

// 우선순위
// 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
// -> hashmap 사용 후 for문 돌려서 max변수에 저장
// 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
// ->
// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
