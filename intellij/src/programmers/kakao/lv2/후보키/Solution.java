package programmers.kakao.lv2.후보키;

import java.util.*;

class Solution {
    ArrayList<String> keys = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        int width = relation[0].length;
        int height = relation.length;
        dfs(-1, "", relation, width);
        Collections.sort(keys);
        ArrayList<String> uniqueKeys = new ArrayList<>();
        for (String key : keys) {
            if (satisfyMinimality(key, uniqueKeys)) {
                uniqueKeys.add(key);
            }
        }
        return uniqueKeys.size();
    }

    private void dfs(int lastIndex, String key, String[][] relation, int len) {

        if (!key.equals("")) {
            if (satisfyUniqueness(relation, key)) {
                keys.add(key);
            }
        }

        if (key.length() == len) {
            return;
        }
        for (int i = lastIndex + 1; i < len; i++) {
            dfs(i, key + i, relation, len);
        }
    }

    private boolean satisfyUniqueness(String[][] relation, String key) {
        int rowCount = relation.length;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;
        for (String[] tuple : relation) {
            sb = new StringBuilder();
            for (char c : key.toCharArray()) {
                sb.append(tuple[c - '0']);
            }
            set.add(sb.toString());
        }

        if (set.size() != rowCount) {
            return false;
        }
        return true;
    }

    private boolean satisfyMinimality(String target, ArrayList<String> keys) {
        for (String key : keys) {
            if (target.startsWith(key)) {
                return false;
            }
        }
        return true;
    }
}
