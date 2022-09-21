package programmers.kakao.year2022.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] idList, String[] reports, int k) {
        int[] answer = new int[idList.length];
        HashSet<String> reportSet = new HashSet<>();
        HashMap<String, Integer> reportedCountMap = new HashMap<>();
        init(idList, reportedCountMap);

        for (String report : reports) {
            if (reportSet.add(report)) {
                String attacker = report.split(" ")[1];
                reportedCountMap.put(attacker, reportedCountMap.get(attacker) + 1);
            }
        }

        HashMap<String, Integer> banCountMap = new HashMap<>(); // 신고자 id : 신고자가 신고한 이용자 중에서 정지된 이용자 수
        init(idList, banCountMap);

        for (String report : reportSet) {
            String[] splitReport = report.split(" ");

            String reporter = splitReport[0];
            String attacker = splitReport[1];

            if (reportedCountMap.get(attacker) >= k) {
                banCountMap.put(reporter, banCountMap.get(reporter) + 1);
            }
        }

        for (int i = 0; i < idList.length; i++) {
            answer[i] = banCountMap.get(idList[i]);
        }

        return answer;
    }

    private static void init(String[] idList, HashMap<String, Integer> reportedCountMap) {
        for (String id : idList) {
            reportedCountMap.put(id, 0);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;

        for (int i : T.solution(id_list, report, k)) {
            System.out.print(i + " ");
        }
    }
}
