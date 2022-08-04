package programmers.kakao.lv2.방금그곡;

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Music> musics = new ArrayList<>();
        ArrayList<String> mArr = convertToInfoList(m);
        // musicinfo : "시작 시각,끝난 시각,음악 제목,악보 정보"
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infoArr = musicinfos[i].split(",");
            int playTime = getPlayTime(infoArr[0], infoArr[1]);
            String musicName = infoArr[2];
            ArrayList<String> originInfo = convertToInfoList(infoArr[3]);
            ArrayList<String> musicInfo = convertToInfoList(getMusicInfo(playTime, originInfo));

            if (contains(mArr, musicInfo)) {
                musics.add(new Music(i, musicName, playTime));
            }
        }
        if (musics.isEmpty()) {
            return "(None)";
        } else {
            Collections.sort(musics);
            return musics.get(0).name;
        }
    }

    private boolean contains(ArrayList<String> info, ArrayList<String> target) {
        if (info.size() > target.size()) {
            return false;
        }
        boolean contains = false;
        for (int i = 0; i <= target.size() - info.size(); i++) {
            for (int j = 0; j < info.size(); j++) {
                if (!info.get(j).equals(target.get(i + j))) {
                    break;
                }

                if (j == info.size() - 1) {
                    contains = true;
                }
            }
        }

        return contains;
    }

    private String getMusicInfo(int playTime, ArrayList<String> originInfo) {
        StringBuilder sb = new StringBuilder();
        int len = originInfo.size();
        for (int i = 0; i < playTime; i++) {
            sb.append(originInfo.get(i % len));
        }

        return sb.toString();
    }

    private ArrayList<String> convertToInfoList(String info) {
        ArrayList<String> infoList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : info.toCharArray()) {
            if (sb.length() == 0) {
                sb.append(c);
                continue;
            }

            if (Character.isAlphabetic(c)) {
                infoList.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(c);
        }
        infoList.add(sb.toString());

        return infoList;
    }

    private int getPlayTime(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");

        return Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]) -
                (Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]));
    }
}

class Music implements Comparable<Music> {
    int index;
    String name;
    int playTime;

    public Music(int index, String name, int playTime) {
        this.index = index;
        this.name = name;
        this.playTime = playTime;
    }

    @Override
    public int compareTo(Music o) {
        if (o.playTime == this.playTime) {
            return this.index - o.index;
        }
        return o.playTime - this.playTime;
    }
}
