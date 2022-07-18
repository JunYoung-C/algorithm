package programmers.kakao.lv1.신규아이디만들기;


class Solution {
    public String solution(String new_id) {
        String changedId = toLowerCase(new_id);
        changedId = getFilteredId(changedId);
        changedId = getThirdId(changedId);
        changedId = getFourthId(changedId);
        changedId = getFifthId(changedId);
        changedId = getSixthId(changedId);
        changedId = getSeventhId(changedId);
        // System.out.println(getSixthId("abcdefghijklmn.p"));
        return changedId;
    }

    private String getSeventhId(String str) {
        while (str.length() < 3) {
            str += str.charAt(str.length() - 1);
        }
        return str;
    }

    private String getSixthId(String str) {
        if (str.length() >= 16) {
            if (str.charAt(14) == '.') {
                str = str.substring(0, 14);
            } else {
                str = str.substring(0, 15);
            }
        }
        return str;
    }

    private String getFifthId(String str) {
        if (str.equals("")) {
            str = "a";
        }

        return str;
    }

    private String getFourthId(String str) {
        if (str.length() >= 1 && str.charAt(0) == '.') {
            str = str.substring(1);
        }

        if (str.length() >= 1 && str.charAt(str.length() - 1) == '.') {
            str = str.substring(0, str.length() - 1);
        }

        return str;
    }

    private String getThirdId(String str) {
        StringBuilder sb = new StringBuilder();
        char prevChar = ' ';
        for (char c : str.toCharArray()) {
            if (c == '.' && prevChar == '.') {
                continue;
            }
            sb.append(c);
            prevChar = c;
        }

        return sb.toString();
    }

    private String getFilteredId(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || c == '.' || (c >= '0' && c <= '9') || c == '-'  || c == '_') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}