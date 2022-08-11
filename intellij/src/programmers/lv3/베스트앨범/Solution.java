package programmers.lv3.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int len = plays.length;
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, PriorityQueue<Music>> genrePQMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!genrePQMap.containsKey(genres[i])) {
                genrePQMap.put(genres[i], new PriorityQueue());
            }
            genrePQMap.get(genres[i]).offer(new Music(i, genres[i], plays[i]));
        }

        ArrayList<Order> orders = new ArrayList<>();
        for (String key : genreMap.keySet()) {
            orders.add(new Order(key, genreMap.get(key)));
        }
        Collections.sort(orders);

        ArrayList<Integer> playList = new ArrayList<>();
        for (Order o : orders) {
            PriorityQueue<Music> genrePQ = genrePQMap.get(o.name);
            playList.add(genrePQ.poll().index);
            if (!genrePQ.isEmpty()) {
                playList.add(genrePQ.poll().index);
            }
        }

        len = playList.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = playList.get(i);
        }

        return answer;
    }
}

class Order implements Comparable<Order> {
    String name;
    int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public int compareTo(Order o) {
        return o.count - this.count;
    }
}

class Music implements Comparable<Music> {
    int index;
    String genre;
    int play;

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
