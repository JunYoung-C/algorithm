package programmers.lv3.여행경로;

import java.util.*;

class Solution {
    ArrayList<String> routes = new ArrayList<>();
    boolean[] isVisited;

    public String[] solution(String[][] tickets) {
        isVisited = new boolean[tickets.length];
        StringBuilder sb = new StringBuilder();
        sb.append("ICN");
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(routes);
        System.out.println(routes.size());
        return routes.get(0).split(",");
    }

    private void dfs(String current, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (current.equals(tickets[i][0]) && !isVisited[i]) {
                isVisited[i] = true;
                dfs(tickets[i][1], route + "," + tickets[i][1], tickets, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
