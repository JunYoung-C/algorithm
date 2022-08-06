package programmers.kakao.lv2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    int number = Integer.parseInt(sb.toString());
                    sb.setLength(0);

                    map.put(number, map.getOrDefault(number, 0) + 1);
                }
            }
        }

        ArrayList<Element> elements = new ArrayList<>();
        for (int key : map.keySet()) {
            elements.add(new Element(key, map.get(key)));
        }
        Collections.sort(elements);

        int len = elements.size();
        answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = elements.get(i).number;
        }
        return answer;
    }

    class Element implements Comparable<Element> {
        int number;
        int count;

        public Element(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return o.count - this.count;
        }
    }
}
