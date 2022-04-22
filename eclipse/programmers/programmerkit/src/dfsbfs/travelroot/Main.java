package dfsbfs.travelroot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
  ArrayList<String> roots = new ArrayList<>();
  boolean[] isVisited;
  int len;

  public String[] solution(String[][] tickets) {
    String[] answer = {};
    len = tickets.length;
    isVisited = new boolean[len];

    dfs(0, "ICN", "ICN", tickets);

    Collections.sort(roots);
    answer = roots.get(0).split(" ");
    return answer;
  }

  void dfs(int L, String root, String now, String[][] tickets) {
    if (L >= len) {
      roots.add(root);
    } else {
      for (int i = 0; i < len; i++) {
        String from = tickets[i][0];
        String to = tickets[i][1];
        if (now.equals(from) && !isVisited[i]) {
          isVisited[i] = true;
          
          dfs(L + 1, root + " " + to, to, tickets);
          
          isVisited[i] = false;
        }
      }
    }
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//    String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

     String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
     {"ATL","SFO"}};

    for (String s : T.solution(tickets)) {
      System.out.print(s + " ");
    }
  }
}
