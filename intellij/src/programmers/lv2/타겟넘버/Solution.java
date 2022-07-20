package programmers.lv2.타겟넘버;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, target);
    }

    private int dfs(int depth, int[] numbers, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(depth + 1, numbers, sum + numbers[depth], target) + dfs(depth + 1, numbers, sum - numbers[depth], target);
    }
}