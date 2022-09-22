package programmers.kakao.year2021.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Spec {
    String language;
    String job;
    String career;
    String food;
    Integer testPoint;
    String[] info;

    public Spec(String language, String job, String career, String food, int testPoint, String[] info) {
        this.language = language;
        this.job = job;
        this.career = career;
        this.food = food;
        this.testPoint = testPoint;
        this.info = info;
    }

    public Spec(String[] info) {
        this(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info);
    }

    public String getQuery(int queryBit) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            if (((1 << i) & queryBit) > 0) {
                sb.append(info[i]);
            } else {
                sb.append("-");
            }

            sb.append(" and ");
        }

        return sb.substring(0, sb.length() - " and ".length()).toString();
    }
}

class Solution {
    public int[] solution(String[] infoArr, String[] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        HashMap<String, ArrayList<Integer>> testPointsQueryMap = new HashMap<>(); // query : 코딩테스트 점수 리스트와 매칭

        for (String info : infoArr) {
            Spec spec = new Spec(info.split(" "));
//            System.out.println(spec.language + " " + spec.job + " " + spec.career + " " + spec.food + " " + spec.testPoint);

            for (int queryBit = 0; queryBit < (1 << 4); queryBit++) {
                String query = spec.getQuery(queryBit);

                if (!testPointsQueryMap.containsKey(query)) {
                    testPointsQueryMap.put(query, new ArrayList<>());
                }

                testPointsQueryMap.get(query).add(spec.testPoint);
            }
        }

        sortTestPoints(testPointsQueryMap);

        for (int i = 0; i < len; i++) {
            String longQuery = queries[i];
            int index = longQuery.lastIndexOf(' ');
            String query = longQuery.substring(0, index);
            int targetPoint = Integer.parseInt(longQuery.substring(index + 1));

            if (testPointsQueryMap.containsKey(query)) {
                ArrayList<Integer> testPoints = testPointsQueryMap.get(query);

                answer[i] = getCount(targetPoint, testPoints);
            }
        }


        return answer;
    }

    private static int getCount(int targetPoint, ArrayList<Integer> testPoints) {
        int index = -1;
        int lt = 0, rt = testPoints.size() - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (testPoints.get(mid) >= targetPoint) {
                rt = mid - 1;
            } else {
                index = mid;
                lt = mid + 1;
            }
        }

        return testPoints.size() - 1 - index;
    }

    private static void sortTestPoints(HashMap<String, ArrayList<Integer>> testPointsQueryMap) {
        for (ArrayList<Integer> testPoints : testPointsQueryMap.values()) {
            Collections.sort(testPoints);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                "- and - and - and chicken 100", "- and - and - and - 150"};

        for (int i : T.solution(info, query)) {
            System.out.print(i + " ");
        }
    }
}