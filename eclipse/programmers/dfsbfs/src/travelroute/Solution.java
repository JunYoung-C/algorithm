package travelroute;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
  boolean[] isVisited;
  ArrayList<String> orders = new ArrayList<>();
  void dfs(int L, int len,String[][] tickets, String now, String sum) {
    if (len == L) {
      orders.add(sum);
    } else {
      for (int i = 0; i < len; i++) {
        String from = tickets[i][0];
        String to = tickets[i][1]; 
        if (from.equals(now) && !isVisited[i]) {
          isVisited[i] = true;
          dfs(L+1, len, tickets, to, sum + " " + to);
          isVisited[i] = false;
        }
      }
    }
  }

  public String[] solution(String[][] tickets) {
    int len = tickets.length;
    isVisited = new boolean[tickets.length];
    dfs(0, len, tickets, "ICN", "ICN");
    
    Collections.sort(orders);
    
    return orders.get(0).split(" ");
  }
}
