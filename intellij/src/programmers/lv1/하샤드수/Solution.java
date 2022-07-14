package programmers.lv1.하샤드수;

class Solution {
    public boolean solution(int x) {
        int sum = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            sum += c - '0';
        }

        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}
