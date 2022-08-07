package programmers.kakao.lv2.메뉴리뉴얼;

import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (String order : orders) {
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            insertData(charArr, 0, "");
        }

        ArrayList<String> courseList = new ArrayList<>();
        Collections.sort(courseList, (o1, o2) -> {
            return o2.length() - o1.length();
        });

        for (int count : course) {
            ArrayList<String> tmp = new ArrayList<>();

            for (String key : map.keySet()) {
                if (map.get(key) == count) {
                    System.out.print(key + " ");
                }
                if (map.get(key) == count && !contains(tmp, key)) {
                    tmp.add(key);
                }
            }
            System.out.println();

            courseList.addAll(tmp);
        }

        int len = courseList.size();
        answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = courseList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private boolean contains(ArrayList<String> strList, String target) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (String str : strList) {
            for (char c : target.toCharArray()) {
                map.put(c, true);
            }

            for (char c : str.toCharArray()) {
                map.put(c, true);
            }

            if (map.size() == str.length()) {
                return true;
            } else if (map.size() == target.length()) {
                strList.remove(str);
            }
        }

//         String[] splitedTarget = target.split("");
//         int len = target.length();
//         for (String str : strList) {
//             int count = 0;
//             for (String t : splitedTarget) {
//                 if (!str.contains(t)) {
//                     count++;
//                 }
//             }

//             if (count == len) {
//                 return true;
//             }
//         }

        return false;
    }

    private void insertData(char[] order, int depth, String key) {
        if (depth == order.length) {
            if (key.length() >= 2) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            return;
        }

        insertData(order, depth + 1, key + order[depth]);
        insertData(order, depth + 1, key);
    }
}
