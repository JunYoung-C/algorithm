package programmers.kakao.year2021.메뉴리뉴얼;

import java.util.*;

class Solution {
    HashMap<String, Integer> courseMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        boolean[] isPossibleCourse = new boolean[11];
        initPossibleCourse(isPossibleCourse, course);

        for (String order : orders) {
            int len = order.length();

            for (int orderBit = 0; orderBit < (1 << len); orderBit++) {
                int bitCount = Integer.bitCount(orderBit);

                if (isPossibleCourse[bitCount]) {
                    addCourse(orderBit, getSortedOrder(order));
                }
            }
        }

        ArrayList<String> courses = new ArrayList<>();
        HashMap<Integer, Integer> maxOrderMap = new HashMap<>();
        initMaxOrderMap(maxOrderMap);

        for (String key : courseMap.keySet()) {
            if (!maxOrderMap.containsKey(key.length())) {
                continue;
            }

            int maxOrderCount = maxOrderMap.get(key.length());
            if (courseMap.get(key) == maxOrderCount) {
                courses.add(key);
            }
        }

        Collections.sort(courses);

        int len = courses.size();
        answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = courses.get(i);
        }
        return answer;
    }

    private void initMaxOrderMap(HashMap<Integer, Integer> maxOrderMap) {
        for (String key : courseMap.keySet()) {
            if (courseMap.get(key) <= 1) {
                continue;
            }

            int len = key.length();
            int maxOrderCount = maxOrderMap.getOrDefault(len, 0);
            int currentOrderCount = courseMap.get(key);
            maxOrderMap.put(len, Math.max(maxOrderCount, currentOrderCount));
        }
    }

    private void addCourse(int orderBit, String order) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            if (((1 << i) & orderBit) > 0) {
                sb.append(order.charAt(i));
            }
        }

        String course = sb.toString();
        courseMap.put(course, courseMap.getOrDefault(sb.toString(), 0) + 1);
    }

    private String getSortedOrder(String order) {
        char[] orderCharArray = order.toCharArray();
        Arrays.sort(orderCharArray);
        return new String(orderCharArray);
    }

    private void initPossibleCourse(boolean[] isPossibleCourse, int[] course) {
        int len = course.length;

        for (int possibleCourse : course) {
            isPossibleCourse[possibleCourse] = true;
        }
    }
}
