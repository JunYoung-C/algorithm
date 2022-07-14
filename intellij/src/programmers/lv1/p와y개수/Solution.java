package programmers.lv1.p와y개수;

class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'y' || c == 'Y') {
                yCount++;
            } else if (c == 'p' || c == 'P') {
                pCount++;
            }
        }

        return pCount == yCount;
    }
}
