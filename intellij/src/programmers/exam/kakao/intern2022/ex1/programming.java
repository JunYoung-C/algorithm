package programmers.exam.kakao.intern2022.ex1;

import java.util.HashMap;
import java.util.Scanner;

// mbti 검사와 비슷한 느낌의 문제였다. 시간 복잡도에 대한 고려 없이 단순 구현으로 풀 수 있는 문제였다.
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] indicators = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}}; // 지표별 사전 순서를 고려하여 배치
        int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> scoreMap = new HashMap<>();
        initScoreMap(indicators, scoreMap);

        setScore(survey, choices, scores, scoreMap);

        for (char[] indicator : indicators) {
            // 점수가 높은 요소가 성격유형
            // 점수가 같으면 첫번째 요소가 성격유형

            if (scoreMap.get(indicator[0]) >= scoreMap.get(indicator[1])) {
                answer += indicator[0];
            } else {
                answer += indicator[1];
            }
        }

        return answer;
    }

    private void setScore(String[] survey, int[] choices, int[] scores, HashMap<Character, Integer> scoreMap) {
        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int choice = choices[i];

            // 1, 2, 3은 type.charAt(0)이 점수 획득
            // 5, 6, 7은 type.charAt(1)이 점수 획득
            // 4는 점수 획득 x

            if (choice <= 3) {
                scoreMap.put(type.charAt(0), scoreMap.get(type.charAt(0)) + scores[choice]);
            } else if (choice >= 5) {
                scoreMap.put(type.charAt(1), scoreMap.get(type.charAt(1)) + scores[choice]);
            }
        }
    }

    private void initScoreMap(char[][] indicators, HashMap<Character, Integer> scoreMap) {
        for (char[] indicator : indicators) {
            for (char c : indicator) {
                scoreMap.put(c, 0);
            }
        }
    }

}

public class programming {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};

        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        System.out.println(T.solution(survey, choices));
    }
}
