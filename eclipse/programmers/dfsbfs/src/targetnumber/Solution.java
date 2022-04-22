package targetnumber;

class Solution {
  int answer = 0;

  void dfs(int L, int sum, int[] numbers, int target) {
    if (L == numbers.length) {
      if (sum == target) answer++;
    } else {
      dfs(L+1, sum + numbers[L], numbers, target);
      dfs(L+1, sum - numbers[L], numbers, target);
    }
    
  }

  public int solution(int[] numbers, int target) {
    dfs(0, 0, numbers, target);
    return answer;
  }
}
