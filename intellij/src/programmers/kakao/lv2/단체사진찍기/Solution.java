package programmers.kakao.lv2.단체사진찍기;

class Solution {
    char[] charArr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] isVisited = new boolean[8];
    int answer = 0;

    public int solution(int n, String[] datas) {
        dfs("", datas);
        return answer;
    }

    private void dfs(String str, String[] datas) {
        if (str.length() == 8) {
            // 판별
            if (isRightOrder(str, datas)) {
                answer++;
            }
            // if (str.startsWith("NRC")) {
            //     System.out.println(str);
            // }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(str + charArr[i], datas);
                isVisited[i] = false;
            }
        }
    }

    private boolean isRightOrder(String str, String[] datas) {
        int index1 = -1, index2 = -1;
        int dif = 0;
        for (String data : datas) {
            index1 = str.indexOf(data.charAt(0));
            index2 = str.indexOf(data.charAt(2));
            dif = Math.abs(index1 - index2) - 1;

            if (data.charAt(3) == '=') {
                if (dif != data.charAt(4) - '0') {
                    return false;
                }
            } else if (data.charAt(3) == '>') {
                if (dif <= data.charAt(4) - '0') {
                    return false;
                }
            } else {
                if (dif >= data.charAt(4) - '0') {
                    return false;
                }
            }
        }

        return true;
    }
}
