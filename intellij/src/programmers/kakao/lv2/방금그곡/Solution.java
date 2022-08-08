package programmers.kakao.lv2.방금그곡;

import java.util.*;

import java.util.*;

class Music implements Comparable<Music> {
    String title;
    int playTime;

    public Music(String title, int playTime) {
        this.title = title;
        this.playTime = playTime;
    }

    @Override
    public int compareTo(Music m) {
        return m.playTime - this.playTime;
    }
}

class Solution {
    Map<String, String> replaceMap =
            Map.of("C#", "H", "D#", "I", "F#", "J", "G#", "K", "A#", "L");

    public String solution(String m, String[] musicinfos) {
        ArrayList<Music> musics = new ArrayList<>();
        m = getReplacedString(m);

        for (String info : musicinfos) { // 시작 시각, 끝난 시각, 음악 제목, 악보 정보
            String[] splitInfo = info.split(",");
            int time = getMinuteTime(splitInfo[0], splitInfo[1]);
            String title = splitInfo[2];
            String music = getChangedMusic(getReplacedString(splitInfo[3]), time);

            if (music.contains(m)) {
                musics.add(new Music(title, time));
            }
        }
        if (musics.isEmpty()) {
            return "(None)";
        } else {
            Collections.sort(musics);
            return musics.get(0).title;
        }
    }

    private String getChangedMusic(String music, int time) {
        StringBuilder sb = new StringBuilder();
        int len = music.length();
        for (int i = 0; i < time / len; i++) {
            sb.append(music);
        }
        sb.append(music.substring(0, time % len));

        return sb.toString();
    }

    private String getReplacedString(String str) {
        for (String key : replaceMap.keySet()) {
            str = str.replaceAll(key, replaceMap.get(key));
        }

        return str;
    }

    private int getMinuteTime(String start, String end) {
        String[] splitStart = start.split(":");
        String[] splitEnd = end.split(":");

        return Integer.parseInt(splitEnd[0]) * 60 + Integer.parseInt(splitEnd[1])
                - (Integer.parseInt(splitStart[0]) * 60 + Integer.parseInt(splitStart[1]));
    }
}
