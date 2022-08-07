package programmers.kakao.lv2.순위검색;

import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] infoArr, String[] queries) {
        int[] answer = {};

        for (String info : infoArr) {
            // 언어, 직군, 경력, 소울 푸드, 코테점수
            String[] splitedInfo = info.split(" ");
            insertData(splitedInfo, "", 0);
        }

        for (ArrayList<Integer> points : map.values()) {
            Collections.sort(points);
        }

        int len = queries.length;
        answer = new int[len];
        int index = 0;
        for (String query : queries) {
            String[] splitedQuery = query.split(" ");
            String key = getQueryKey(splitedQuery);
            int findPoint = Integer.parseInt(splitedQuery[7]);
            // 사람 구하기
            if (map.containsKey(key)) {
                answer[index++] = getCount(map.get(key), findPoint);
            } else {
                answer[index++] = 0;
            }
        }

        return answer;
    }

    private int getCount(ArrayList<Integer> points, int target) {
        int lt = 0, rt = points.size() - 1;
        int index = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (points.get(mid) >= target) {
                index = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        if (index == -1) {
            return 0;
        } else {
            return points.size() - index;
        }
    }

    private String getQueryKey(String[] query) {
        return query[0] + query[2] + query[4] + query[6];
    }

    private void insertData(String[] info, String key, int depth) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.parseInt(info[4]));
            return;
        }

        insertData(info, key + info[depth], depth + 1);
        insertData(info, key + "-", depth + 1);
    }
}
