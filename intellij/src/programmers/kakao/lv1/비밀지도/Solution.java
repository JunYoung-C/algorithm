package programmers.kakao.lv1.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String row = Integer.toString(arr1[i] | arr2[i], 2);
            // System.out.println(row);
            answer[i] = row.replaceAll("1", "#").replaceAll("0", " ");
            while (answer[i].length() < n) {
                answer[i] = " " + answer[i];
            }
        }
        return answer;
    }
}