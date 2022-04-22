package network;

class Solution {
  boolean[] isVisited;

  void dfs(int computer, int[][] computers, int n) {
    for (int LinkedComp = 0; LinkedComp < n; LinkedComp++) {
      if (computer != LinkedComp && !isVisited[LinkedComp] && computers[computer][LinkedComp] == 1) {
        isVisited[LinkedComp] = true;
        dfs(LinkedComp, computers, n);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;
    isVisited = new boolean[n];
    for (int computer = 0; computer < n; computer++) {
      if (!isVisited[computer]) {
        answer++;
        dfs(computer, computers, n);
      }
    }
    return answer;
  }
}


