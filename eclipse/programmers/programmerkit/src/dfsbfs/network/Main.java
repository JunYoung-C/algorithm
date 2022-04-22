package dfsbfs.network;

import java.util.Scanner;

class Solution {
  static boolean[] isVisited;
  public int solution(int n, int[][] computers) {
      int answer = 0;
      isVisited = new boolean[n];
      
      for (int i = 0; i < n; i++) {
        if (!isVisited[i]) {
          // 해당노드 방문처리와 카운팅 후 해당 노드와 연결된 노드들도 방문처리
          isVisited[i] = true;
          answer++;
          dfs(i, computers[i], n, computers);
        }
      }
      return answer;
  }
  
  void dfs(int myComputer, int[] otherComputers,int n, int[][] computers) {
    for (int i = 0; i < n; i++) {
      if (i == myComputer) {
        continue;
      }
      
      if (!isVisited[i] && otherComputers[i] == 1) {
        isVisited[i] = true;
        dfs(i, computers[i], n, computers);
      }
    }
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
//    int n = 3;
//    int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    
    int n = 3;
    int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 0, 1}};
    
    System.out.println(T.solution(n, computers));
  }
}