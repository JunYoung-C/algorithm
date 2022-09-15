package programmers.kakao.lv3.길찾기게임;

import java.util.*;

class Solution {
    ArrayList<Integer> heights;
    ArrayList<Integer> preorder = new ArrayList<>();
    ArrayList<Integer> postorder = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        initHeights(nodeinfo);

        setOrder(0, 0, 100000, nodeinfo);

        int len = nodeinfo.length;
        answer = new int[2][len];
        for (int i = 0; i < len; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }

        return answer;
    }

    private void setOrder(int heightIndex, int minX, int maxX, int[][] nodeInfo) {
        if (heightIndex >= heights.size()) {
            return;
        }
        int parentHeight = heights.get(heightIndex);
        int parentX = -1;
        int parentIndex = -1;

        for (int i = 0; i < nodeInfo.length; i++) {
            int[] node = nodeInfo[i];
            if (node[1] == parentHeight && node[0] >= minX && node[0] <= maxX) {
                parentIndex = i;
                parentX = node[0];
            }
        }

        if (parentIndex == -1) {
            return;
        }

        preorder.add(parentIndex + 1);
        setOrder(heightIndex + 1, minX, parentX - 1, nodeInfo);
        setOrder(heightIndex + 1, parentX + 1, maxX, nodeInfo);
        postorder.add(parentIndex + 1);
    }

    private void initHeights(int[][] nodeinfo) {
        HashSet<Integer> heightSet = new HashSet<>();
        for (int[] node : nodeinfo) {
            heightSet.add(node[1]);
        }
        heights = new ArrayList<>(heightSet);
        Collections.sort(heights, Collections.reverseOrder());
    }
}

