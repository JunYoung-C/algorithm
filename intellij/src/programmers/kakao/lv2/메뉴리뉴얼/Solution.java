package programmers.kakao.lv2.메뉴리뉴얼;

import java.util.*;

class MenuInfo implements Comparable<MenuInfo>{
    String menu;
    int count;

    public MenuInfo(String menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    @Override
    public int compareTo(MenuInfo o) {
        return o.count - this.count;
    }
}

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

        for (int courseCount : course) {
            ArrayList<MenuInfo> menuList = new ArrayList<>();

            for (String key : map.keySet()) {
                if (key.length() == courseCount) {
                    menuList.add(new MenuInfo(key, map.get(key)));
                }
            }

            if (menuList.isEmpty()) {
                continue;
            }

            Collections.sort(menuList);
            int maxCount = menuList.get(0).count;
            if (maxCount < 2) {
                continue;
            }
            for (MenuInfo menuInfo : menuList) {
                if (menuInfo.count == maxCount) {
                    courseList.add(menuInfo.menu);
                }
            }
        }

        int len = courseList.size();
        answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = courseList.get(i);
        }
        Arrays.sort(answer);
        return answer;
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