package programmers.kakao.lv1.신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        // 동일 유저 신고 횟수 1로 고정 -> 신고자(user) : 신고당한자(target)를 map?
        // 유저 : 신고 당한 횟수
        // 정지된 id : 신고한 id 리스트

        // 처음에는 id_list를 set을 사용하여 중복을 제거한다.
        // 신고당한사람 id : 신고자(user) 리스트 -> list.size()가 신고 당한 횟수
        // user - id_list의 인덱스, id

        Set<String> reportSet = new HashSet<>(); // 중복 제거용
        for (String r : reports) {
            reportSet.add(r);
        }

        HashMap<String, User> userMap = new HashMap<>(); // 이름 : user로 매칭
        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], new User(i, id_list[i]));
        }

        HashMap<String, ArrayList<User>> reportMap = new HashMap<>();
        for (String report : reportSet) {
            String[] tmp = report.split(" ");
            String reporter = tmp[0]; // 신고자 id
            String target = tmp[1]; // 신고당한사람 id

            if (!reportMap.containsKey(target)) {
                reportMap.put(target, new ArrayList<User>());
            }
            reportMap.get(target).add(userMap.get(reporter));
        }

        // System.out.println(reportMap.size());
        for (ArrayList<User> reporters : reportMap.values()) {
            // System.out.println(reporters.size());
            if (reporters.size() < k) {
                continue;
            }

            for (User reporter : reporters) {
                answer[reporter.index]++;
            }
        }
        return answer;
    }
}

class User {
    int index;
    String id;

    public User(int index, String id) {
        this.index = index;
        this.id = id;
    }
}