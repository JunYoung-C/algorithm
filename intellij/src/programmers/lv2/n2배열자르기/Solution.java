package programmers.lv2.n2배열자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = Math.max((int)((long)(i + left) / n + 1), (int)((long)(i + left) % n + 1));
        }
        return answer;
    }
}
