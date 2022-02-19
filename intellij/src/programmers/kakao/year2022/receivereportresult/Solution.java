package programmers.kakao.year2022.receivereportresult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userCnt = id_list.length;
        int[] answer = new int[userCnt];
        // 신고하는 사람 : set(가해자1, 가해자2) 형태
        HashMap<String, Set<String>> reporterMap = new HashMap<>();
        // 신고당하는 사람 : set(신고자1, 신고자 2) 형태
        HashMap<String, Set<String>> attackerMap = new HashMap<>();

        for (int i = 0; i < userCnt; i++) {
            reporterMap.put(id_list[i], new HashSet());
            attackerMap.put(id_list[i], new HashSet());
        }

        for (String str : report) {
            String[] strArr = str.split(" ");
            String reporter = strArr[0];
            String attacker = strArr[1];

            reporterMap.get(reporter).add(attacker);
            attackerMap.get(attacker).add(reporter);
        }

        for (int i = 0; i < userCnt; i++) {
            for (String attackerStr : reporterMap.get(id_list[i])) {
                if (attackerMap.get(attackerStr).size() >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        for (int i : T.solution(id_list, report, k)) {
            System.out.print(i + " ");
        }
    }
}
