package programmers.kakao.lv3.길찾기게임;

import java.util.*;

class Solution {
    int height = 0, width = 0;
    int[][] nodeList;
    ArrayList<Integer> prefixList = new ArrayList<>();
    ArrayList<Integer> postfixList = new ArrayList<>();

    public int[][] solution(int[][] nodeInfo) {
        int[][] answer = {};
        if (nodeInfo.length == 1) {
            return new int[][] {{1}, {1}};
        }

        compress(nodeInfo);

        nodeList = new int[height][width];
        int index = 1;
        for (int[] node : nodeInfo) {
            nodeList[node[1]][node[0]] = index++;
        }

        dfs(0, width - 1, height - 1);

        answer = new int[2][width];
        for (int i = 0; i < width; i++) {
            answer[0][i] = prefixList.get(i);
            answer[1][i] = postfixList.get(i);
        }

        return answer;
    }

    private void dfs(int x1, int x2, int y) {
        if (y == -1) {
            return;
        }

        int x = x1;
        for (; x <= x2; x++) {
            if (nodeList[y][x] != 0) {
                prefixList.add(nodeList[y][x]);
                break;
            }
        }

        if (x - 1 >= x1) {
            dfs(x1, x - 1, y - 1);
        }

        if (x + 1 <= x2) {
            dfs(x + 1, x2, y - 1);
        }

        postfixList.add(nodeList[y][x]);
    }

    private void compress(int[][] nodeInfo) {
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int[] node : nodeInfo) {
            xList.add(node[0]);
            yList.add(node[1]);
        }

        ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<>(xList));
        ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<>(yList));

        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);

        height = uniqueYList.size();
        width = uniqueXList.size();

        for (int[] node : nodeInfo) {
            node[0] = uniqueXList.indexOf(node[0]);
            node[1] = uniqueYList.indexOf(node[1]);
        }
    }
}

