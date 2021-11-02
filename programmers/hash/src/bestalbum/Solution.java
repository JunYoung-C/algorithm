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

      // �÷��̼� ���� �帣 ���� �� map���� ����
      for (String genre : map.keySet()) {
        if (map.get(genre) > max) {
          max = map.get(genre);
          maxGenre = genre;
        }
      }
      map.remove(maxGenre);
      
      // �÷��̼� ���� �帣�� �ΰ� ����
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

// �켱����
// ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
// -> hashmap ��� �� for�� ������ max������ ����
// �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
// ->
// �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
