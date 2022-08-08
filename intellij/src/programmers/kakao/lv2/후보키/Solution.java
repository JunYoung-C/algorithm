package programmers.kakao.lv2.후보키;

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int colLen = relation[0].length;
        int rowLen = relation.length;
        ArrayList<Integer> conditions = new ArrayList<>();

        for (int condition = 1; condition < (1 << colLen); condition++) {
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < rowLen; row++) {
                for (int col = 0; col < colLen; col++) {
                    if ((condition & (1 << col)) > 0) {
                        sb.append(relation[row][col]);
                        sb.append(" ");
                    }
                }

                set.add(sb.toString());
                sb.setLength(0);
            }

            if (set.size() == rowLen && isPossible(condition, conditions)) {
                conditions.add(condition);
            }
        }

        return conditions.size();
    }

    private boolean isPossible(int condition, ArrayList<Integer> conditions) {
        for (int c : conditions) {
            if ((c & condition) == c) {
                return false;
            }
        }
        return true;
    }

}
