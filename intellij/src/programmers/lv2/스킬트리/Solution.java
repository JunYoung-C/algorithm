package programmers.lv2.스킬트리;

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean isRightOrder = true;
        int len = skill.length();
        int index = -1;
        int[] indegree = new int[len];
        Arrays.fill(indegree, 1);
        indegree[0] = 0;

        for (String skillTree : skill_trees) {
            for (char c : skillTree.toCharArray()) {
                index = skill.indexOf(c);
                if (index == -1) {
                    continue;
                }

                if (indegree[index] == 1) {
                    isRightOrder = false;
                    break;
                }

                if (index < len - 1) {
                    indegree[index + 1] = 0;
                }
            }

            if (isRightOrder) {
                answer++;
            }
            isRightOrder = true;
            index = -1;
            indegree = new int[len];
            Arrays.fill(indegree, 1);
            indegree[0] = 0;
        }
        return answer;
    }
}
